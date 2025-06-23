package com.seba.plantsorganizer.plants.model

data class PlantUiModel(
    val name: String = "",
    val description: String = "",
    val photoPath: String = "",
    val isFavourite: Boolean = false,
)
