package com.seba.plantsorganizer.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seba.plantsorganizer.R

@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier,
    drawableId: Int,
    descriptionStringId: Int,
    isSelected: Boolean,
) {
    Box(
        modifier = modifier.size(dimensionResource(id = R.dimen.app_bar_height))
    ) {
        Image(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            painter = painterResource(id = drawableId),
            contentDescription = stringResource(id = descriptionStringId),
            colorFilter = if (isSelected) ColorFilter.tint(colorResource(id = R.color.tab_selected_color)) else ColorFilter.tint(
                colorResource(id = R.color.white)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBar() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .height(dimensionResource(id = R.dimen.app_bar_height))
            .background(color = colorResource(id = R.color.app_main_color)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var isPlantsClicked by remember { mutableStateOf(true) }
        var isFavouritesClicked by remember { mutableStateOf(false) }

        BottomBarItem(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    isPlantsClicked = true
                    isFavouritesClicked = false
                    onTabClicked(context, context.getString(R.string.tab_home))
                },
            drawableId = R.drawable.ic_flower,
            descriptionStringId = R.string.plant_content_description,
            isSelected = isPlantsClicked,
        )

        VerticalDivider(
            color = colorResource(id = R.color.white), thickness = 1.dp, modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 4.dp)
        )

        BottomBarItem(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    isPlantsClicked = false
                    isFavouritesClicked = true
                    onTabClicked(context, context.getString(R.string.tab_favourites))
                },
            drawableId = R.drawable.ic_favourite,
            descriptionStringId = R.string.favourites_content_description,
            isSelected = isFavouritesClicked,
        )
    }
}

private fun onTabClicked(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}