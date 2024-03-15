package com.seba.plantsorganizer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seba.plantsorganizer.R

@Preview(showBackground = true)
@Composable
fun AddPlantTopBar(navController: NavHostController = rememberNavController()) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(dimensionResource(id = R.dimen.app_bar_height))
            .background(color = colorResource(id = R.color.app_main_color))
            .wrapContentHeight(align = Alignment.CenterVertically),
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically

    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = colorResource(
                    id = R.color.white
                )
            )
        }
        Text(
            text = stringResource(id = R.string.add_plant_top_bar_title),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontStyle = FontStyle.Normal,
            fontSize = 21.sp
        )
    }
}