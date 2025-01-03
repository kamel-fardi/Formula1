package com.kamelfardi.formula1.ui.screens.home




import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kamelfardi.formula1.ui.sections.CircuitsSection
import com.kamelfardi.formula1.ui.sections.CurrenciesSection
import com.kamelfardi.formula1.ui.sections.DriverSection
import com.kamelfardi.formula1.ui.theme.Formula1AppUITheme
import com.kamelfardi.formula1.ui.sections.UpcomingSection


@Composable
fun HomeScreen(navController: NavController) {
    Formula1AppUITheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ) {

                    UpcomingSection()
                    CircuitsSection()
                    Spacer(modifier = Modifier.height(16.dp))
                    DriverSection()
                    CurrenciesSection()
                }



            }
        }
    }
}