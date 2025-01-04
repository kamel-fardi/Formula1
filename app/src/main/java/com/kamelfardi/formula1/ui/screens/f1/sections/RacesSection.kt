package com.kamelfardi.formula1.ui.screens.f1.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamelfardi.formula1.R

@Preview
@Composable
fun UpcomingSection() {
    Column {
        Text(
            text = stringResource(R.string.upcoming_racings),
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onBackground
        )


    }


}














