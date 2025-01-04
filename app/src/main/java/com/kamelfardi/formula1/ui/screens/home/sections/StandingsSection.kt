package com.kamelfardi.formula1.ui.screens.home.sections

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.data.Constructor
import com.kamelfardi.formula1.data.Currency
import com.kamelfardi.formula1.ui.theme.BlueEnd
import com.kamelfardi.formula1.ui.theme.BlueStart
import com.kamelfardi.formula1.ui.theme.GreenStart

val constructors = listOf(
    Constructor(
        constructorId = "1",
        name = "Mercedes",
        nationality = "German",
        points = 573,
        position = 1,
        wins = 10,
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        url = "https://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One"


    ),
    Constructor(
        name = "Ferrari",
        constructorId = "2",
        points = 400,
        position = 2,
        wins = 5,
        url = "https://en.wikipedia.org/wiki/Scuderia_Ferrari",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "Italian"
    ),
    Constructor(
        name = "Red Bull Racing",
        constructorId = "3",
        points = 319,
        position = 3,
        wins = 3,
        url = "https://en.wikipedia.org/wiki/Red_Bull_Racing",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "Austrian"
    ),
    Constructor(
        name = "McLaren",
        constructorId = "4",
        points = 202,
        position = 4,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/McLaren",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "British"
    ),
    Constructor(
        name = "Aston Martin",
        constructorId = "5",
        points = 195,
        position = 5,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/Aston_Martin",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "British"
    ),
    Constructor(
        name = "Alpine",
        constructorId = "6",
        points = 115,
        position = 6,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/Alpine_F1_Team",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "French"
    ),
    Constructor(
        name = "Haas",
        constructorId = "7",
        points = 84,
        position = 7,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/Haas_F1_Team",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "American"
    ),
    Constructor(
        name = "RB",
        constructorId = "8",
        points = 84,
        position = 8,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/Red_Bull_R",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "British"
    ),
    Constructor(
        name = "Kick Sauber",
        constructorId = "9",
        points = 84,
        position = 9,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/Alfa_Romeo",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "Swiss"
    ),
    Constructor(
        name = "Williams",
        constructorId = "10",
        points = 84,
        position = 10,
        wins = 0,
        url = "https://en.wikipedia.org/wiki/Williams",
        color = com.kamelfardi.formula1.ui.screens.f1.sections.getGradient(BlueStart, BlueEnd),
        nationality = "British"
    )



)

@Preview
@Composable
fun StandingsSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else {
                            Icons.Rounded.KeyboardArrowDown
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = stringResource(R.string.standings),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = stringResource(R.string.standings),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 5.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                modifier = Modifier.width(width),
                                text = stringResource(R.string.constructor),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )


                            Text(
                                modifier = Modifier.width(width),
                                text = stringResource(R.string.points),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )


                            Text(
                                modifier = Modifier.width(width),
                                text = stringResource(R.string.wins),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(constructors.size) { index ->
                                ConstrutorItem(
                                    index = index,
                                    width = width
                                )
                            }
                        }

                    }
                }
            }
        }

    }

}

@Composable
fun ConstrutorItem(index: Int, width: Dp) {
    val constructor = constructors[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.size(22.dp),
                text = "${constructor.position}",
                fontWeight = FontWeight.Bold,
            )

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = constructor.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "${constructor.points}",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "${constructor.wins}",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

    }
}

















