package com.pvv.calculator.logic

class SeparatorButton : CalcButton {

    override val caption: String
        get() = decimalSeparator.toString()

    override fun operation(state: DataState): DataState =
           if (!(state.current.contains(decimalSeparator)))
               state.copy(current = state.current+decimalSeparator,
                          isEmptyCurrent = false)
           else state
}