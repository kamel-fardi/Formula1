package com.kamelfardi.formula1.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.ui.theme.Formula1AppUITheme

@Composable
fun ProfileScreen(navController: NavController) {
    Formula1AppUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp)
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                        .clip(MaterialTheme.shapes.large)
                ) {
                    Image(
                        painter = painterResource(R.drawable.albon),
                        contentDescription = "profile_screen_bg",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    "Profile Screen",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
        }
    }
}