package com.seba.plantsorganizer.presentation.viewmodel

import com.seba.plantsorganizer.data.mapper.PlantMapper
import com.seba.plantsorganizer.domain.model.Plant
import com.seba.plantsorganizer.domain.usecase.GetPlantsUseCase
import com.seba.plantsorganizer.plants.viewmodel.MainViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    // Dispatcher testowy
    private val testDispatcher = StandardTestDispatcher()

    // Use case (będzie mockowany)
    private lateinit var getPlantsUseCase: GetPlantsUseCase


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        getPlantsUseCase = mockk()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `plantsUiState should emit mapped data from use case`() = runTest {
        val domainPlants = listOf(
            Plant(name = "Monstera", isFavourite = true),
            Plant(name = "Aloes", isFavourite = false)
        )
        val expectedUi = domainPlants.map { PlantMapper.domainToUiModel(it) }

        every { getPlantsUseCase() } returns flowOf(domainPlants)

        val viewModel = MainViewModel(getPlantsUseCase)

        advanceUntilIdle() // <- ważne!

        val actual = viewModel.realPlants.drop(1).first() // <- pomiń initialValue
        assertEquals(expectedUi, actual)
    }
}