package com.seba.plantsorganizer.core.mapper

import com.seba.plantsorganizer.data.model.PlantEntity
import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.presentation.model.PlantUiModel

object PlantMapper {

    fun entityToDomain(entity: PlantEntity): Plant = Plant(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        photoPath = entity.photoPath,
        isFavourite = entity.isFavourite
    )

    fun domainToEntity(plant: Plant): PlantEntity = PlantEntity(
        id = plant.id,
        name = plant.name,
        description = plant.description,
        photoPath = plant.photoPath,
        isFavourite = plant.isFavourite
    )

    fun domainToUiModel(plant: Plant): PlantUiModel = PlantUiModel(
        name = plant.name,
        description = plant.description,
        photoPath = plant.photoPath,
        isFavourite = plant.isFavourite
    )
}