package com.seba.plantsorganizer.plantdetails.model

data class PlantDetailUiModel(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val photoPath: String = "",
    val isFavourite: Boolean = false,
)
