package com.seba.plantsorganizer.plants.plants

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.seba.plantsorganizer.plants.plants.EmptyPlantsList
import com.seba.plantsorganizer.plants.plants.PlantsList
import com.seba.plantsorganizer.plants.model.PlantUiModel

@Composable
fun HomeTab(
    plants: List<PlantUiModel>,
    onPlantClick: (Long) -> Unit,
    listState: LazyListState,
    modifier: Modifier
) {
    if (plants.isEmpty()) {
        EmptyPlantsList()
    } else {
        PlantsList(
            plantsList = plants,
            onPlantClick = onPlantClick,
            listState = listState,
            modifier = modifier
        )
    }
}