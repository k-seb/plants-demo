package com.seba.plantsorganizer.presentation.component.plants

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.presentation.model.PlantUiModel

@OptIn(ExperimentalGlideComposeApi::class)
@Preview(showBackground = true)
@Composable
fun PlantsListItem(modifier: Modifier = Modifier, plant: PlantUiModel = PlantUiModel()) {
    Card(
        colors = CardColors(
            colorResource(R.color.white),
            colorResource(R.color.white),
            colorResource(R.color.white),
            colorResource(R.color.white)
        ),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        modifier = modifier
            .fillMaxWidth()
            .size(120.dp)
            .border(
                1.dp,
                colorResource(id = R.color.light_gray),
                RoundedCornerShape(corner = CornerSize(10.dp))
            ),
    ) {
        Row(
            modifier = modifier
                .background(colorResource(id = R.color.white))
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            GlideImage(
                model = plant,
                modifier = modifier
                    .padding(8.dp)
                    .clip(CircleShape),
                contentDescription = "",
                loading = placeholder(R.drawable.monstera),
                failure = placeholder(R.drawable.monstera)
            ) {
                it.load(plant.photoPath)
            }

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .weight(0.85f)
                    .padding(vertical = 8.dp),
            ) {
                Text(
                    text = plant.name,
                    color = colorResource(id = R.color.black),
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.size(8.dp))
                Text(
                    text = plant.description,
                    color = colorResource(id = R.color.gray),
                    style = TextStyle(lineHeight = 15.sp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            val tintColor = if (plant.isFavourite) R.color.red else R.color.light_gray
            Icon(
                painter = painterResource(id = R.drawable.ic_favourite),
                tint = colorResource(tintColor),
                modifier = modifier
                    .weight(0.15f)
                    .align(Alignment.Bottom)
                    .padding(bottom = 4.dp),
                contentDescription = null
            )
        }
    }
}