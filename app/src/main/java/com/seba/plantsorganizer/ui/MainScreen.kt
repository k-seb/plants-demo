package com.seba.plantsorganizer.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core.ui.component.FloatingButton
import com.seba.plantsorganizer.plantdetails.navigation.plantDetailsNavGraph
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.core.ui.R
import com.seba.plantsorganizer.core.ui.TopBarWithBackButton
import com.seba.plantsorganizer.plants.component.BottomNavigationBar
import com.seba.plantsorganizer.plants.component.TopBar
import com.seba.plantsorganizer.plants.navigation.plantsNavGraph
import com.seba.plantsorganizer.plants.viewmodel.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)

    val homeListState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }
    val favListState = rememberSaveable(saver = LazyListState.Saver) { LazyListState() }

    var detailsTopBar by remember { mutableStateOf<(@Composable () -> Unit)?>(null) }

    val viewModel: MainViewModel = hiltViewModel()

    val onPlantClick: (Long) -> Unit = { plantId ->
        navController.navigate("${C.DETAILS_ROUTE}/$plantId")
    }

    Scaffold(
        topBar = {
            when {
                currentRoute == C.ADD_PLANT_ROUTE -> {
                    TopBarWithBackButton(
                        { navController.popBackStack() },
                        context.getString(R.string.add_plant_top_bar_title)
                    )
                }

                currentRoute?.startsWith("${C.DETAILS_ROUTE}/") == true -> {
                    detailsTopBar?.invoke()
                }

                else -> TopBar()
            }
        },
        floatingActionButton = {
            if (currentRoute == C.HOME_ROUTE || currentRoute == C.FAV_ROUTE) {
                FloatingButton(navController, currentRoute)
            }
        },
        bottomBar = {
            if (currentRoute == C.HOME_ROUTE || currentRoute == C.FAV_ROUTE) {
                BottomNavigationBar(navController)
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = C.HOME_ROUTE,
            modifier = Modifier
        ) {
            plantsNavGraph(
                onPlantClick = onPlantClick,
                viewModel = viewModel,
                homeListState = homeListState,
                favListState = favListState
            )
            plantDetailsNavGraph(
                navController = navController,
                onTopBarReady = { detailsTopBar = it }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}