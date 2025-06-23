package com.seba.plantsorganizer.plants.model

import com.seba.plantsorganizer.domain.model.Plant

object PlantUiModelMapper {
    fun domainToUiModel(plant: Plant): PlantUiModel = PlantUiModel(
        name = plant.name,
        description = plant.description,
        photoPath = plant.photoPath,
        isFavourite = plant.isFavourite
    )
}