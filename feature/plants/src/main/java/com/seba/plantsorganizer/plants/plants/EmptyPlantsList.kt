package com.seba.plantsorganizer.plants.plants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.seba.plantsorganizer.plants.R
import com.seba.plantsorganizer.core.ui.R as UiR

@OptIn(ExperimentalGlideComposeApi::class)
@Preview(showBackground = true)
@Composable
fun EmptyPlantsList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            model = Unit,
            modifier = modifier
                .padding(8.dp)
                .size(300.dp, 300.dp),
            contentDescription = "",
            loading = placeholder(UiR.drawable.empty_list_placeholder),
            failure = placeholder(UiR.drawable.empty_list_placeholder),

            ) {
            it.load(UiR.drawable.empty_list_placeholder)
        }
        Text(
            text = stringResource(id = R.string.empty_plants_list_text),
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Center,
        )
    }
}

