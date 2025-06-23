package com.seba.plantsorganizer.domain.model

data class Plant(
    val id: Long = 0L,
    val name: String = "",
    val description: String = "",
    val photoPath: String = "",
    val isFavourite: Boolean = false
)
