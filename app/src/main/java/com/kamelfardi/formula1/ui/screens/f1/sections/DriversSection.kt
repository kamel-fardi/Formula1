package com.kamelfardi.formula1.ui.screens.f1.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.Utils.Avatar
import com.kamelfardi.formula1.Utils.flags
import com.kamelfardi.formula1.data.Driver

val driversList = listOf(
    Driver(
        driverId = "1",
        givenName = "Lewis",
        familyName = "Hamilton",
        dateOfBirth = "1985-01-07",
        code = "HAM",
        url = "http://en.wikipedia.org/wiki/Lewis",
        permanentNumber = "44",
        nationality = "British",
        constructorName = "Mercedes",
        backgroundColor = 0xFF29595A
    ),
    Driver(
        driverId = "2",
        givenName = "Valtteri",
        familyName = "Bottas",
        dateOfBirth = "1989-08-28",
        code = "BOT",
        url = "http://en.wikipedia.org/wiki/Valtteri",
        permanentNumber = "22",
        nationality = "Finnish",
        constructorName = "Kick Sauber",
        backgroundColor = 0xFF205627

    ),
    Driver(
        driverId = "3",
        givenName = "Max",
        familyName = "Verstappen",
        dateOfBirth = "1997-09-30",
        code = "VER",
        url = "http://en.wikipedia.org/wiki/Max",
        permanentNumber = "33",
        nationality = "Dutch",
        constructorName = "Red Bull Racing",
        backgroundColor = 0xFF2C3B58
    ),
)

@Preview
@Composable
fun DriversSection() {
    Column {
        Text(
            text = stringResource(R.string.drivers),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,

            )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(driversList.size) {
                DriverItem(it)
            }
        }
    }
}

@Composable
fun DriverItem(
    index: Int
) {
    val driver = driversList[index]
    var lastPaddingEnd = 0.dp
    if (index == driversList.size - 1) {
        lastPaddingEnd = 16.dp
    }


    Box(
        modifier = Modifier
            .padding( end = 20.dp )
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(Color(driver.backgroundColor))
                .width(300.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val avatar = Avatar.fromDriverName(driver.familyName)
            val flag = flags.fromCountryName(driver.nationality)

            val image = if (avatar != null) {
                painterResource(id = avatar.getDrawableResourceId())
            } else {
                painterResource(id = R.drawable.albon) // Default avatar in case of no match
            }
            val flagimage = if (flag != null) {
                painterResource(id = flag.getDrawableResourceId())
            } else {
                painterResource(id = R.drawable.uae_flag) // Default avatar in case of no match
            }

            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {

                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier

                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "${driver.givenName} ${driver.familyName}",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2, // Ensures the text is constrained to one line
                        overflow = TextOverflow.Ellipsis // Adds "..." if the text overflows
                    )
                    Text(text =driver.dateOfBirth,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1, // Ensures the text is constrained to one line
                        overflow = TextOverflow.Ellipsis // Adds "..." if the text overflows
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "${driver.permanentNumber} ",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1, // Ensures the text is constrained to one line
                            overflow = TextOverflow.Ellipsis // Adds "..." if the text overflows
                        )
                        Image(
                            painter = flagimage,
                            contentDescription = driver.nationality,
                            modifier = Modifier
                                .width(60.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                    }
                }
            }





        }
    }
}













