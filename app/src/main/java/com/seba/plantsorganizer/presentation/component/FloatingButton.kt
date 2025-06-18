package com.seba.plantsorganizer.presentation.component

import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.core.constants.C

@Composable
fun FloatingButton(navController: NavHostController, route: String) {
    if (route != C.ADD_PLANT_ROUTE) {
        FloatingActionButton(
            onClick = {
                navController.navigate(C.ADD_PLANT_ROUTE)
            },
            modifier = Modifier.offset(y = (-32).dp),
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