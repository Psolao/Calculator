package com.pvv.calculator.logic

class SingleStringOperatorButton(override val caption : String,
                                 val operation : (String) -> String) :CalcButton {
    override fun operation(state: DataState): DataState {
            return state.copy(
                current = operation(state.getStringCurrent()),
                isEmptyCurrent = false)
    }
}