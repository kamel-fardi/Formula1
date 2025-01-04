package com.kamelfardi.formula1.ui.screens.f1.sections


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.Utils.constructorImg
import com.kamelfardi.formula1.Utils.constructorlogo
import com.kamelfardi.formula1.Utils.flags
import com.kamelfardi.formula1.data.Constructor
import com.kamelfardi.formula1.ui.theme.BlueEnd
import com.kamelfardi.formula1.ui.theme.BlueStart
import com.kamelfardi.formula1.ui.theme.OrangeEnd
import com.kamelfardi.formula1.ui.theme.OrangeStart
import com.kamelfardi.formula1.ui.theme.PurpleEnd
import com.kamelfardi.formula1.ui.theme.PurpleStart

val constructors = listOf(

    Constructor(
        constructorId = "alpine",
        name = "Alpine",
        url = "https://www.formula1.com/en/teams/Alpine.html",
        nationality = "French",
        position = 10,
        points = 0,
        wins = 0,
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Constructor(
        constructorId = "aston_martin",
        name = "Aston Martin",
        url = "https://www.formula1.com/en/teams/Aston-Martin.html",
        nationality = "British",
        position = 7,
        points = 7,
        wins = 0,
        color = getGradient(BlueStart, BlueEnd),
    ),

    Constructor(
        constructorId = "ferrari",
        name = "Ferrari",
        url = "https://www.formula1.com/en/teams/Ferrari.html",
        nationality = "Italian",
        position = 6,
        points = 14,
        wins = 0,
        color = getGradient(OrangeStart, OrangeEnd),
    ),

    Constructor(
        constructorId = "haas",
        name = "Haas",
        url = "https://www.formula1.com/en/teams/Haas.html",
        nationality = "American",
        position = 9,
        points = 0,
        wins = 0,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Constructor(
        constructorId = "mclaren",
        name = "McLaren",
        url = "https://www.formula1.com/en/teams/McLaren.html",
        nationality = "British",
        position = 3,
        points = 41,
        wins = 0,
        color = getGradient(BlueStart, BlueEnd),
        ),

)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun ConstructorsSection() {
    LazyRow {
        items(constructors.size) { index ->
            ConstructorItem(index)
        }
    }
}

@Composable
fun ConstructorItem(
    index: Int
) {
    val constructor = constructors[index]
    var lastItemPaddingEnd = 0.dp
    if (index == constructors.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    val flag = flags.fromCountryName(constructor.nationality)
    val constructorImg = constructorImg.fromConstructorName(constructor.constructorId)
    val constructorlogo = constructorlogo.fromConstructorName(constructor.constructorId)

    val constructorlg = if (constructorlogo != null) {
        painterResource(id = constructorlogo.getDrawableResourceId())
    } else {
        painterResource(id = R.drawable.mercedes_logo)
    }

    val constructorimage = if (constructorImg != null) {
        painterResource(constructorImg.getDrawableResourceId())
    } else {
        painterResource(id = R.drawable.monaco)
    }

    val image = if (flag != null) {
        painterResource(id = flag.getDrawableResourceId())
    } else {
        painterResource(id = R.drawable.uae_flag) // Default avatar in case of no match
    }


    Box(
        modifier = Modifier
            .padding( end = 20.dp )
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(constructor.color)
                .width(300.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(3.dp),

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(
                        painter = constructorlg,
                        contentDescription = constructor.nationality,
                        modifier = Modifier
                            .width(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Image(
                        painter = image,
                        contentDescription = constructor.nationality,
                        modifier = Modifier
                            .width(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = constructor.name,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = constructorimage,
                    contentDescription = constructor.constructorId,
                    modifier = Modifier
                        .aspectRatio(constructorimage.intrinsicSize.width / constructorimage.intrinsicSize.height)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .graphicsLayer(
                            translationX = 30f, // Move the image 20 dp to the right
                            scaleX = 1.5f, // Scale up by 1.5 times on the X-axis
                            scaleY = 1.5f  // Scale up by 1.5 times on the Y-axis
                        )
                        .clip(RoundedCornerShape(10.dp))
                )


            }


        }
    }
}





























