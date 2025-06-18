package com.seba.plantsorganizer.domain.repository

import com.seba.plantsorganizer.domain.model.Plant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakePlantsRepository(
    private val plants: List<Plant> = emptyList()
) : PlantsRepository {
    override fun getPlants(): Flow<List<Plant>> = flowOf(plants)
}