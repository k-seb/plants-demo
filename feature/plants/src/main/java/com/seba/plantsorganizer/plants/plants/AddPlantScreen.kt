package com.seba.plantsorganizer.plants.plants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seba.plantsorganizer.core.ui.R
import com.seba.plantsorganizer.plants.viewmodel.MainViewModel

@Preview(showBackground = true)
@Composable
fun AddPlantScreen(viewModel: MainViewModel = hiltViewModel(), modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.add_plant_top_bar_title),
            color = colorResource(id = R.color.black)
        )
    }
}