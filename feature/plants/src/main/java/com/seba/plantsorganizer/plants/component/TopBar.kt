package com.seba.plantsorganizer.plants.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.seba.plantsorganizer.plants.R

@Preview(showBackground = true)
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(dimensionResource(id = R.dimen.app_bar_height))
            .background(color = colorResource(id = R.color.app_main_color))
            .wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Text(
            text = stringResource(id = R.string.top_bar_title),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            modifier = Modifier.fillMaxWidth(),
            fontStyle = FontStyle.Normal,
            fontSize = 21.sp
        )
    }
}