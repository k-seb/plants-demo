package com.seba.plantsorganizer.plants.plants

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.seba.plantsorganizer.plants.component.plants.EmptyFavouritesPlantsList
import com.seba.plantsorganizer.plants.component.plants.PlantsList
import com.seba.plantsorganizer.plants.model.PlantUiModel

@Composable
fun FavouriteTab(
    plants: List<PlantUiModel>,
    onPlantClick: (Long) -> Unit,
    listState: LazyListState,
    modifier: Modifier,
) {
    val favouritePlants = plants.filter { it.isFavourite }

    if (favouritePlants.isEmpty()) {
        EmptyFavouritesPlantsList()
    } else {
        PlantsList(
            plantsList = plants,
            onPlantClick = onPlantClick,
            listState = listState,
            modifier = modifier
        )
    }
}