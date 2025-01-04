package com.kamelfardi.formula1.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.ui.screens.f1.sections.CircuitsSection
import com.kamelfardi.formula1.ui.screens.f1.sections.ConstructorsSection
import com.kamelfardi.formula1.ui.screens.f1.sections.DriversSection
import com.kamelfardi.formula1.ui.theme.Formula1AppUITheme

@Composable
fun F1Screen(navController: NavController) {
    Formula1AppUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),

                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.Circuits),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                CircuitsSection()
                Text(
                    text = stringResource(R.string.constructors),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground

                )
                Spacer(modifier = Modifier.height(8.dp))
                ConstructorsSection()
                Spacer(modifier = Modifier.height(10.dp))
                DriversSection()
                Spacer(modifier = Modifier.height(10.dp))
                DriversSection()

            }
        }
    }
}