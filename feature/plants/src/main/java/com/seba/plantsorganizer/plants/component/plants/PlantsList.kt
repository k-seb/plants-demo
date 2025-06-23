package com.seba.plantsorganizer.plants.component.plants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seba.plantsorganizer.plants.R
import com.seba.plantsorganizer.plants.model.PlantUiModel

@Composable
fun PlantsList(
    plantsList: List<PlantUiModel>,
    listState: LazyListState,
    modifier: Modifier,
    onPlantClick: (Long) -> Unit
) {
    Column(
        modifier = modifier
            .padding(
                horizontal = 8.dp,
                vertical = dimensionResource(id = R.dimen.app_bar_height)
            )
            .fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp),
        ) {
            item {
                Text(
                    text = "Salon",
                    color = colorResource(id = R.color.black),
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            items(plantsList) {
                PlantsListItem(Modifier, it, onPlantClick)
            }
        }
    }
}