package com.seba.plantsorganizer.plantdetails

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.seba.plantsorganizer.core.ui.R
import com.seba.plantsorganizer.core.ui.TopBarWithBackButton

@Composable
fun PlantDetailsScreen(
    navController: NavHostController,
    onTopBarReady: (@Composable () -> Unit) -> Unit
) {
    val context = LocalContext.current
    val viewModel: PlantDetailsViewModel = hiltViewModel()
    val plant by viewModel.plant.collectAsState()

    LaunchedEffect(plant?.name) {
        onTopBarReady {
            TopBarWithBackButton(
                onClickAction = { navController.popBackStack() },
                title = plant?.name ?: context.getString(R.string.details_top_bar_title)
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        plant?.let {
            Text(text = it.name)
        } ?: CircularProgressIndicator()
    }
}
