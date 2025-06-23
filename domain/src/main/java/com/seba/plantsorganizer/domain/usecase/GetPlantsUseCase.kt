package com.seba.plantsorganizer.domain.usecase

import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.domain.repository.PlantsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlantsUseCase @Inject constructor(
    private val repository: PlantsRepository
) {
    operator fun invoke(): Flow<List<Plant>> {
        return repository.getPlants()
    }
}