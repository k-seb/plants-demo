package com.seba.plantsorganizer.plants.model

data class PlantUiModel(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val photoPath: String = "",
    val isFavourite: Boolean = false,
)
