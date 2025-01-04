package com.kamelfardi.formula1.ui.screens.home




import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.ui.screens.home.sections.CircuitsSection
import com.kamelfardi.formula1.ui.screens.home.sections.DriverSection
import com.kamelfardi.formula1.ui.screens.home.sections.StandingsSection
import com.kamelfardi.formula1.ui.theme.Formula1AppUITheme


@Composable
fun HomeScreen(navController: NavController) {
    Formula1AppUITheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),

            ) {

                Text(
                    text = stringResource(R.string.upcoming_racings),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground

                )
                Spacer(modifier = Modifier.height(8.dp))
                CircuitsSection()
                Spacer(modifier = Modifier.height(10.dp))
                DriverSection()
                StandingsSection()
            }
        }
    }
}