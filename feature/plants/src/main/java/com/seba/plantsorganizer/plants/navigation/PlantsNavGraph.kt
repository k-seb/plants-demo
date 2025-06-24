package com.seba.plantsorganizer.plants.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.lazy.LazyListState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.plants.plants.PlantsScreen
import com.seba.plantsorganizer.plants.viewmodel.MainViewModel

fun NavGraphBuilder.plantsNavGraph(
    viewModel: MainViewModel,
    homeListState: LazyListState,
    onPlantClick: (Long) -> Unit,
    favListState: LazyListState
) {
    composable(
        C.HOME_ROUTE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        PlantsScreen(
            route = C.HOME_ROUTE,
            onPlantClick = onPlantClick,
            viewModel = viewModel,
            homeListState = homeListState,
            favListState = favListState
        )
    }
    composable(
        C.FAV_ROUTE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        PlantsScreen(
            route = C.FAV_ROUTE,
            onPlantClick = onPlantClick,
            viewModel = viewModel,
            homeListState = homeListState,
            favListState = favListState
        )
    }
    composable(
        C.ADD_PLANT_ROUTE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        PlantsScreen(
            route = C.ADD_PLANT_ROUTE,
            onPlantClick = onPlantClick,
            viewModel = viewModel,
            homeListState = homeListState,
            favListState = favListState
        )
    }
}