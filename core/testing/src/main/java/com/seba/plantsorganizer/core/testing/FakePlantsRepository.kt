package com.seba.plantsorganizer.core.testing

import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.domain.repository.PlantsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakePlantsRepository(
    private var plants: List<Plant> = defaultPlants
) : PlantsRepository {

    override fun getPlants(): Flow<List<Plant>> = flowOf(plants)

    override fun getPlantById(id: Long): Flow<Plant?> =
        flowOf(plants.find { it.id == id })

    fun setPlants(plants: List<Plant>) {
        this.plants = plants
    }

    companion object {
        val defaultPlants = listOf(
            Plant(1L, "Aloe", "Aloe Vera", "", true),
            Plant(2L, "Monstera", "Monstera Deliciosa", "", true),
            Plant(3L, "Cactus", "Cactus", "", false),
            Plant(4L, "Ficus", "Ficus Benjamina", "", false),
            Plant(5L, "Orchid", "Orchidaceae", "", false),
            Plant(6L, "Fern", "Nephrolepis", "", false),
        )
    }
}