package com.kamelfardi.formula1.ui.screens.f1.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamelfardi.formula1.R
import com.kamelfardi.formula1.Utils.Circuitimage
import com.kamelfardi.formula1.Utils.flags
import com.kamelfardi.formula1.data.Circuit
import com.kamelfardi.formula1.data.Location
import com.kamelfardi.formula1.ui.theme.BlueEnd
import com.kamelfardi.formula1.ui.theme.BlueStart
import com.kamelfardi.formula1.ui.theme.GreenEnd
import com.kamelfardi.formula1.ui.theme.GreenStart
import com.kamelfardi.formula1.ui.theme.OrangeEnd
import com.kamelfardi.formula1.ui.theme.OrangeStart
import com.kamelfardi.formula1.ui.theme.PurpleEnd
import com.kamelfardi.formula1.ui.theme.PurpleStart

val circuits = listOf(

    Circuit(
        circuitId = "monaco",
        circuitName = "Circuit de Monaco",
        Location = Location(
            lat = "45.6156",
            long = "9.28111",
            locality = "Monza",
            country = "Monaco"
        ),
        url = "https://www.formula1.com/content/fom-website/en/circuits/monaco.html",
        date = "20-06-2025",
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Circuit(
        circuitId = "bahrain",
        circuitName = "Bahrain Circuit",
        Location = Location(
            lat = "26.0325",
            long = "50.5106",
            locality = "Sakhir",
            country = "Bahrain"
        ),
        url = "https://www.formula1.com/content/fom-website/en/circuits/bahrain.html",
        date = "27-06-2025",
        color = getGradient(BlueStart, BlueEnd),
    ),

    Circuit(
        circuitId = "saudi-arabia",
        circuitName = "Jeddah Circuit",
        Location = Location(
            lat = "21.5433",
            long = "39.1728",
            locality = "Jeddah",
            country = "Saudi Arabia"
        ),
        url = "https://www.formula1.com/content/fom-website/en/circuits/saudi-arabia.html",
        date = "04-07-2025",
        color = getGradient(OrangeStart, OrangeEnd),
    ),

    Circuit(
        circuitId = "japan",
        circuitName = "Suzuka Course",
        Location = Location(
            lat = "34.8431",
            long = "136.5411",
            locality = "Suzuka",
            country = "Japan"
        ),
        url = "https://www.formula1.com/content/fom-website/en/circuits/japan.html",
        date = "11-07-2025",
        color = getGradient(GreenStart, GreenEnd),
    ),
)



@Preview
@Composable
fun CircuitsSection() {
    LazyRow {
        items(circuits.size) { index ->
            CircuitItem(index)
        }
    }
}

@Composable
fun CircuitItem(
    index: Int
) {
    val circuit = circuits[index]
    var lastItemPaddingEnd = 0.dp
    if (index == circuits.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    val flag = flags.fromCountryName(circuit.Location.country)

    val circuitImg = Circuitimage.fromCircuitName(circuit.circuitId)

    val circuitimage = if (circuitImg != null) {
        painterResource(id = circuitImg.getDrawableResourceId())
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
                .background(circuit.color)
                .width(300.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = image,
                        contentDescription = circuit.circuitName,
                        modifier = Modifier
                            .width(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = circuit.circuitName,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = circuit.Location.locality,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = circuit.date,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(

                    painter = circuitimage,

                    contentDescription = circuit.circuitName,
                    modifier = Modifier
                        .fillMaxWidth(1.2f)
                        .clip(RoundedCornerShape(10.dp))
                )
            }

        }
    }
}





























