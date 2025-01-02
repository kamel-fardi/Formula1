package com.kamelfardi.formula1.ui.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kamelfardi.formula1.BottomNavigationBar
import com.kamelfardi.formula1.CardsSection
import com.kamelfardi.formula1.CurrenciesSection
import com.kamelfardi.formula1.FinanceSection
import com.kamelfardi.formula1.ui.theme.Formula1AppUITheme
import com.kamelfardi.formula1.WalletSection


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

            ) {

                WalletSection()
                CardsSection()
                Spacer(modifier = Modifier.height(16.dp))
                FinanceSection()
                CurrenciesSection()
            }


        }
    }
}