package com.pvv.calculator.logic

class ResetButton: CalcButton {
    override val caption: String
        get() = "CE"

    override fun operation(state: DataState): DataState {
        return state.copy(current = "0", isEmptyCurrent = true)
    }
}


class ResetAllButton: CalcButton {
    override val caption: String
        get() = "C"

    override fun operation(state: DataState): DataState {
        return DataState(memory = state.memory, isEmptyCurrent = true)
    }
}