package com.seba.plantsorganizer.plants.plants

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.plants.viewmodel.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlantsScreen(
    route: String,
    viewModel: MainViewModel,
    onPlantClick: (Long) -> Unit,
    homeListState: LazyListState,
    favListState: LazyListState
) {
    val plantsList = viewModel.realPlants.collectAsState()

    when (route) {
        C.HOME_ROUTE -> HomeTab(
            plants = plantsList.value,
            onPlantClick = onPlantClick,
            listState = homeListState,
            modifier = Modifier
        )

        C.FAV_ROUTE -> FavouriteTab(
            plants = plantsList.value.filter { it.isFavourite },
            onPlantClick = onPlantClick,
            listState = favListState,
            modifier = Modifier
        )

        C.ADD_PLANT_ROUTE -> AddPlantScreen()
    }
}