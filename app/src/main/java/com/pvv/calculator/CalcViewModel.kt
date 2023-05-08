package com.pvv.calculator

import androidx.lifecycle.ViewModel
import com.pvv.calculator.logic.CalcButton
import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalcViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataState())
    val uiState: StateFlow<DataState> = _uiState.asStateFlow()

    val repository = Repository()

    fun onButtonPress(button: CalcButton){
        _uiState.update { curState ->
            button.operation(curState)
        }
    }
}