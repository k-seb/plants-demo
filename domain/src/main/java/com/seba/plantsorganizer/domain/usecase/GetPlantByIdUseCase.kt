package com.seba.plantsorganizer.domain.usecase

import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.domain.repository.PlantsRepository
import kotlinx.coroutines.flow.Flow

class GetPlantByIdUseCase(
    private val repository: PlantsRepository
) {
    operator fun invoke(id: Long): Flow<Plant?> = repository.getPlantById(id)
}