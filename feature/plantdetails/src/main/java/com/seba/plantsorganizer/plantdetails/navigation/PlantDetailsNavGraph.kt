package com.seba.plantsorganizer.plantdetails.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.plantdetails.PlantDetailsScreen

fun NavGraphBuilder.plantDetailsNavGraph(
    navController: NavHostController,
    onTopBarReady: (@Composable () -> Unit) -> Unit

) {
    composable(
        route = "${C.DETAILS_ROUTE}/{plantId}",
        arguments = listOf(navArgument("plantId") { type = NavType.LongType }),
        enterTransition = { EnterTransition.None }, exitTransition = { ExitTransition.None }
    ) { backStackEntry ->
        val plantId = backStackEntry.arguments?.getLong("plantId") ?: return@composable
        PlantDetailsScreen(
            navController = navController,
            onTopBarReady = onTopBarReady
        )
    }
}
