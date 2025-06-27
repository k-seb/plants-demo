package com.seba.plantsorganizer.data.mapper

import com.seba.plantsorganizer.data.model.PlantEntity
import com.seba.plantsorganizer.domain.model.Plant
import org.junit.Assert.assertEquals
import org.junit.Test

class PlantMapperTest {
    @Test
    fun entityToDomain() {
        val entityPlant =
            PlantEntity(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        val expectedDomain =
            Plant(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        assertEquals(expectedDomain, PlantMapper.entityToDomain(entityPlant))
    }

    @Test
    fun domainToEntity() {
        val domainPlant =
            Plant(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        val expectedEntity =
            PlantEntity(name = "Monstera", isFavourite = true, description = "Piękna monstera")
        assertEquals(expectedEntity, PlantMapper.domainToEntity(domainPlant))
    }
}