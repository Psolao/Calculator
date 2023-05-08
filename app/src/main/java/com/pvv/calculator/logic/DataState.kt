package com.pvv.calculator.logic

import java.text.DecimalFormatSymbols

val decimalSeparator = DecimalFormatSymbols().decimalSeparator
class CalcOperation (
   val caption : String,
   val oper : (Double, Double) -> Double,
   )

data class DataState (
    val current : String = "0",
    val previous : Double? = null,
    val operation : CalcOperation? = null,
    val Memory : Double? = null,
    var isEmptyCurrent :Boolean = false
){
    fun getStringCurrent():String = if (isEmptyCurrent) "0" else current
    fun getDoubleCurrent():Double = getStringCurrent().replace(decimalSeparator,'.').toDoubleOrNull() ?: 0.0
}