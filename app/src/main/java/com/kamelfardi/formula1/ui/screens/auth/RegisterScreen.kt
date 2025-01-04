package com.kamelfardi.formula1.ui.screens.auth

import android.app.DatePickerDialog
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.android.material.datepicker.MaterialDatePicker
import com.kamelfardi.formula1.data.User
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(
    viewModel: AuthViewModel = AuthViewModel(),
    onUserRegistered: (User) -> Unit
) {
    val context = LocalContext.current
    val datePicker = remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        viewModel.imageUrl.value = uri?.toString() ?: ""
    }
    val calendar = Calendar.getInstance()

    // This will hold the formatted date selected from the picker
    var selectedDate by remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            // Format the selected date
            selectedDate = "$year-${month + 1}-$dayOfMonth"
            viewModel.dateOfBirth.value = selectedDate
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Register",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // First Name
        OutlinedTextField(
            value = viewModel.firstName.value,
            onValueChange = { viewModel.firstName.value = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // Last Name
        OutlinedTextField(
            value = viewModel.lastName.value,
            onValueChange = { viewModel.lastName.value = it },
            label = { Text("Last Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            singleLine = true
        )

        // Open the DatePicker dialog when the user clicks the Date field
        OutlinedTextField(
            value = selectedDate,
            onValueChange = {},
            label = { Text("Date of Birth") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clickable {

                    datePickerDialog.show()
                },
            singleLine = true
        )


        // Image Picker
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Selected Image:",
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { launcher.launch("image/*") }) {
                Text("Pick Image")
            }
        }
        if (viewModel.imageUrl.value.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(viewModel.imageUrl.value),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(top = 8.dp)
            )
        }

        // Email
        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            singleLine = true
        )

        // Password
        OutlinedTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            singleLine = true
        )

        // Register Button
        Button(
            onClick = {
                val user = viewModel.registerUser()
                if (user != null) {
                    onUserRegistered(user)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text(text = "Register")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterViewPreview() {
    MaterialTheme {
        RegisterView(
            viewModel = AuthViewModel(),
            onUserRegistered = { user ->
                println("Preview Registered User: $user")
            }
        )
    }
}
