package com.pvv.calculator.logic

class DualOperatorButton (private val operation : CalcOperation ): CalcButton {
    override val caption: String
        get() = operation.caption

    override fun operation(state: DataState): DataState =
        state.copy(previous = state.getDoubleCurrent(),
                   operation = operation,
                   isEmptyCurrent = true )
}