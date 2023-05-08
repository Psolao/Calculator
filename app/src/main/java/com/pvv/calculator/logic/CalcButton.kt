package com.pvv.calculator.logic

interface CalcButton {
    val caption : String
    fun operation (state: DataState): DataState
}