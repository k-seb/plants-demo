package com.seba.plantsorganizer.domain.repository

import com.seba.plantsorganizer.domain.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    fun addPlant(plant: Plant) = Unit

    fun getPlants(): Flow<List<Plant>>

    fun removePlant(plant: Plant) = Unit
}