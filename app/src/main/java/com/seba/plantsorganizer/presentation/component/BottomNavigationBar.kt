package com.seba.plantsorganizer.presentation.component

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.seba.plantsorganizer.R

@Preview(showBackground = true)
@Composable
fun BottomNavigationBar(navController: NavHostController = rememberNavController()) {
    val items = listOf(Screen.Home, Screen.FavouritesList)

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(modifier = Modifier.background(colorResource(id = R.color.app_main_color)),
                label = { Text(stringResource(screen.stringId)) },
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(screen.drawableId),
                        contentDescription = stringResource(
                            id = R.string.plant_content_description
                        ),
                        tint = colorResource(id = if (selected) R.color.tab_selected_color else R.color.white)
                    )
                })
        }
    }
}