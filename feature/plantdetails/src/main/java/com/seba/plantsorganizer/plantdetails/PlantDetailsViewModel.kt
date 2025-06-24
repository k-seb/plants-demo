package com.seba.plantsorganizer.plantdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seba.plantsorganizer.domain.usecase.GetPlantByIdUseCase
import com.seba.plantsorganizer.plantdetails.model.PlantDetailUiModelMapper
import com.seba.plantsorganizer.plantdetails.model.PlantDetailUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlantDetailsViewModel @Inject constructor(
    getPlantByIdUseCase: GetPlantByIdUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val plantId: Long = savedStateHandle["plantId"] ?: -1L
    val plant: StateFlow<PlantDetailUiModel?> = getPlantByIdUseCase(
        plantId
    ).map {
        it?.let { PlantDetailUiModelMapper.domainToUiModel(it) }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)
}