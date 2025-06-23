package com.seba.plantsorganizer.core.mapper

import com.seba.plantsorganizer.data.mapper.PlantMapper
import com.seba.plantsorganizer.data.model.PlantEntity
import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.plants.model.PlantUiModel
import org.junit.Assert.assertEquals
import org.junit.Test

class PlantMapperTest {
    @Test
    fun entityToDomain() {
        val entityPlant = PlantEntity(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        val expectedDomain = Plant(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        assertEquals(expectedDomain, PlantMapper.entityToDomain(entityPlant))
    }

    @Test
    fun domainToEntity() {
        val domainPlant = Plant(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        val expectedEntity = PlantEntity(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        assertEquals(expectedEntity, PlantMapper.domainToEntity(domainPlant))
    }

    @Test
    fun domainToUiModel() {
        val domainPlants = Plant(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        val expectedUi = PlantUiModel(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        assertEquals(expectedUi, PlantMapper.domainToUiModel(domainPlants))
    }
}