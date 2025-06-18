package com.seba.plantsorganizer.presentation.screen.plants

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.presentation.component.BottomNavigationBar
import com.seba.plantsorganizer.presentation.component.FloatingButton
import com.seba.plantsorganizer.presentation.component.TopBar
import com.seba.plantsorganizer.presentation.component.plants.AddPlantTopBar
import com.seba.plantsorganizer.presentation.component.plants.EmptyFavouritesPlantsList
import com.seba.plantsorganizer.presentation.component.plants.EmptyPlantsList
import com.seba.plantsorganizer.presentation.component.plants.PlantsList
import com.seba.plantsorganizer.presentation.viewmodel.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlantsScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    var route by remember { mutableStateOf(C.HOME_ROUTE) }
    val navController = rememberNavController()

    val homeListState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }
    val favListState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }

    Scaffold(
        topBar = {
            if (route == C.ADD_PLANT_ROUTE) {
                AddPlantTopBar(navController)
            } else {
                TopBar()
            }
        },
        bottomBar = {
            NavHost(
                navController = navController,
                startDestination = C.HOME_ROUTE,
            ) {
                composable(C.HOME_ROUTE) { route = C.HOME_ROUTE }
                composable(C.FAV_ROUTE) { route = C.FAV_ROUTE }
                composable(C.ADD_PLANT_ROUTE) { route = C.ADD_PLANT_ROUTE }
            }
            if (route != C.ADD_PLANT_ROUTE) {
                BottomNavigationBar(navController)
            }
        },
        containerColor = colorResource(id = R.color.white),
        floatingActionButton = { FloatingButton(navController = navController, route = route) }
    ) {
        val plantsLists = viewModel.plantsUiState.collectAsState()

        val favPlantsList = plantsLists.value.filter { it.isFavourite }

        when (route) {
            C.HOME_ROUTE -> {
                if (plantsLists.value.isNotEmpty()) {
                    PlantsList(plantsLists.value, homeListState, modifier)
                } else {
                    EmptyPlantsList(modifier)
                }
            }

            C.FAV_ROUTE -> {
                if (favPlantsList.isNotEmpty()) {
                    PlantsList(favPlantsList, favListState, modifier)
                } else {
                    EmptyFavouritesPlantsList(modifier)
                }
            }

            C.ADD_PLANT_ROUTE -> {
                AddPlantScreen(viewModel, modifier)
            }
        }
    }
}