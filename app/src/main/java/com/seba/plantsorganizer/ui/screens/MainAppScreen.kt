package com.seba.plantsorganizer.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.ui.components.AddPlantTopBar
import com.seba.plantsorganizer.ui.components.BottomNavigationBar
import com.seba.plantsorganizer.ui.components.TopBar
import com.seba.plantsorganizer.ui.core.C

@Preview(showBackground = true)
@Composable
fun MainAppScreen() {
    val context = LocalContext.current
    var route by remember { mutableStateOf(C.HOME_ROUTE) }
    val navController = rememberNavController()

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
    ) { innerPadding ->
        val plantsList = emptyList<String>()

        if (plantsList.isEmpty()) {
            Content(route)
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

            }
            //TODO lazy list
        }
    }
}

@Composable
fun FloatingButton(navController: NavHostController, route: String) {
    if (route != C.ADD_PLANT_ROUTE) {
        FloatingActionButton(
            onClick = {
                navController.navigate(C.ADD_PLANT_ROUTE)
            },
            containerColor = colorResource(id = R.color.app_main_color)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyList() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.empty_plants_list_text),
            color = colorResource(id = R.color.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Content(route: String = C.HOME_ROUTE) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val text = when (route) {
            C.HOME_ROUTE -> R.string.empty_plants_list_text
            C.FAV_ROUTE -> R.string.empty_favourites_list_text
            C.ADD_PLANT_ROUTE -> R.string.add_plant_top_bar_title
            else -> R.string.app_name
        }
        Text(
            text = stringResource(text),
            color = colorResource(id = R.color.black)
        )
    }
}