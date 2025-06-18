package com.seba.plantsorganizer.data.repository

import com.seba.plantsorganizer.core.mapper.PlantMapper
import com.seba.plantsorganizer.data.local.PlantDAO
import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.domain.repository.PlantsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlantsRepositoryImpl(private val dao: PlantDAO) : PlantsRepository {

    override fun getPlants(): Flow<List<Plant>> {
        return dao.getPlants().map { list ->
            list.map { PlantMapper.entityToDomain(it) }
        }
    }

    override fun addPlant(plant: Plant) {
        dao.addPlant(PlantMapper.domainToEntity(plant))
    }

    override fun removePlant(plant: Plant) {
        dao.removePlant(PlantMapper.domainToEntity(plant))
    }
}