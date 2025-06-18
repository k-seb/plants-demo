package com.seba.plantsorganizer.di

import com.seba.plantsorganizer.domain.repository.PlantsRepository
import com.seba.plantsorganizer.domain.usecase.GetPlantsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPlantsUseCase(
        repository: PlantsRepository
    ): GetPlantsUseCase {
        return GetPlantsUseCase(repository)
    }
}