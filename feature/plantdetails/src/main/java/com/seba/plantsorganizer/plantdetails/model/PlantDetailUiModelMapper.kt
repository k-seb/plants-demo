package com.seba.plantsorganizer.plantdetails.model

import com.seba.plantsorganizer.domain.model.Plant

object PlantDetailUiModelMapper {
    fun domainToUiModel(plant: Plant): PlantDetailUiModel = PlantDetailUiModel(
        id = plant.id,
        name = plant.name,
        description = plant.description,
        photoPath = plant.photoPath,
        isFavourite = plant.isFavourite
    )
}