package com.pvv.calculator.logic

import java.text.DecimalFormatSymbols

class SeparatorButton : CalcButton {
    private val separator = DecimalFormatSymbols().decimalSeparator

    override val caption: String
        get() = separator.toString()

    override fun operation(state: DataState): DataState =
           if (!(state.current.contains(separator)))
               state.copy(current = state.current+separator,
                          isEmptyCurrent = false)
           else state
}