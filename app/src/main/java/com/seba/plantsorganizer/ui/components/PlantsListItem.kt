package com.seba.plantsorganizer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seba.plantsorganizer.R

@Preview(showBackground = false)
@Composable
fun PlantsListItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
    ) {
        Row(
            modifier = modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                modifier = modifier
                    .fillMaxHeight()
                    .clip(CircleShape)
                    .background(
                        color = colorResource(
                            id = R.color.teal_700
                        )
                    ),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
            )

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(4.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "PlantName", color = colorResource(id = R.color.black), fontSize = 21.sp, fontWeight = FontWeight.Bold)

                Text(text = "PlantDescription", color = colorResource(id = R.color.gray))
            }
        }

    }
}