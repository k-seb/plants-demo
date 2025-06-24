package com.seba.plantsorganizer.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

@Composable
fun TopBarWithBackButton(
    onClickAction: () -> Unit,
    title: String = ""
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(dimensionResource(id = R.dimen.app_bar_height))
            .background(color = colorResource(id = R.color.app_main_color))
    ) {
        IconButton(
            onClick = onClickAction,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = colorResource(id = R.color.white)
            )
        }

        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            color = colorResource(id = R.color.white),
            fontStyle = FontStyle.Normal,
            fontSize = 21.sp
        )

        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd),
            enabled = false
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.Transparent
            )
        }
    }
}