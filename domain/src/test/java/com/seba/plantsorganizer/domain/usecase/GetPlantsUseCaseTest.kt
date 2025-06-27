package com.seba.plantsorganizer.domain.usecase

import app.cash.turbine.test
import com.seba.plantsorganizer.core.testing.FakePlantsRepository
import com.seba.plantsorganizer.domain.model.Plant
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Test

class GetPlantsUseCaseTest {

    private fun createUseCaseWith(plants: List<Plant>): GetPlantsUseCase {
        val fakeRepository = FakePlantsRepository(plants)
        return GetPlantsUseCase(fakeRepository)
    }

    @Test
    fun `use case returns list of plants`() = runTest {
        val testPlants = listOf(
            Plant(name = "Monstera", isFavourite = true),
            Plant(name = "Aloes", isFavourite = false)
        )

        val useCase = createUseCaseWith(testPlants)

        useCase().test {
            val result = awaitItem()
            assertEquals(2, result.size)
            assertEquals("Monstera", result[0].name)
            assertEquals(true, result[0].isFavourite)
            assertEquals(false, result.first { it.name == "Aloes" }.isFavourite)
            awaitComplete()
        }
    }

    @Test
    fun `use case returns empty list when repository has no data`() = runTest {
        val useCase = createUseCaseWith(emptyList())

        useCase().test {
            val result = awaitItem()
            assertTrue(result.isEmpty())
            awaitComplete()
        }
    }
}