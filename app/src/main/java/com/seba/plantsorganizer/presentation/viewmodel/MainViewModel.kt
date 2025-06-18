package com.seba.plantsorganizer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.core.mapper.PlantMapper
import com.seba.plantsorganizer.domain.usecase.GetPlantsUseCase
import com.seba.plantsorganizer.presentation.model.PlantUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getPlantsUseCase: GetPlantsUseCase,
) : ViewModel() {
    private val samplePlants = List(7) { index ->
        PlantUiModel(
            name = C.POPULAR_HOUSE_PLANTS.random(),
            description = C.PLANT_DESCRIPTION_PLACEHOLDER,
            isFavourite = index % 3 == 0
        )
    }
    private val _fakePlants = MutableStateFlow(samplePlants)

    val fakePlants: StateFlow<List<PlantUiModel>> = _fakePlants

    val plantsUiState: StateFlow<List<PlantUiModel>> =
        getPlantsUseCase()
            .map { list -> list.map { PlantMapper.domainToUiModel(it) } }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
}