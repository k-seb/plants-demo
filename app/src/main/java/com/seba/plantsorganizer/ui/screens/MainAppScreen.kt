package com.seba.plantsorganizer.ui.screens

import android.widget.Toast
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.ui.components.BottomBar
import com.seba.plantsorganizer.ui.components.TopBar

@Preview(showBackground = true)
@Composable
fun MainAppScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomBar()
        },
        containerColor = colorResource(id = R.color.white),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(
                        context,
                        "you will be redirected to add plant screen soon",
                        Toast.LENGTH_SHORT
                    ).show()
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
    ) { innerPadding ->
        val plantsList = emptyList<String>()

        if (plantsList.isEmpty()) {
            EmptyList()
        } else {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {

            }
            //TODO list view
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
            text = stringResource(id = R.string.empty_list_text),
            color = colorResource(id = R.color.black)
        )
    }
}