package com.pvv.calculator.logic

class DigitButton(val digit: Char) : CalcButton {
    init {
        if (digit < '0' || digit > '9')
            throw RuntimeException("Invalid argumnent!")
    }

    override val caption: String
        get() = digit.toString()

    override fun operation(state: DataState): DataState {
        val digitStr = digit.toString()
        return state.copy(current =
            when (state.getStringCurrent()) {
                "0" -> digitStr
                else -> state.current+digitStr
            },
            isEmptyCurrent = false
        )
    }
}