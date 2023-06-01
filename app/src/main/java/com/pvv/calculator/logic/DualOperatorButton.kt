package com.pvv.calculator.logic

class DualOperatorButton(private val operation: CalcOperation) : CalcButton {
    override val caption: String
        get() = operation.caption

    override fun operation(state: DataState): DataState {
        val execState = ExecuteButton.execute(state)
        return execState.copy(
            previous = execState.getDoubleCurrent(),
            operation = operation,
            isEmptyCurrent = true
        )
    }
}