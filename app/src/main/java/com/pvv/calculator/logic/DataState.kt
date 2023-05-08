package com.pvv.calculator.logic

class CalcOperation (
   val oper : (Double, Double) -> Double,
   val caption : String)

data class DataState (
    val current : String = "0",
    val previous : Double? = null,
    val operation : CalcOperation? = null,
    val Memory : Double? = null,
    var isEmptyCurrent :Boolean = false
){
    fun getStringCurrent():String = if (isEmptyCurrent) "0" else current
    fun getDoubleCurrent():Double = getStringCurrent().toDoubleOrNull() ?: 0.0
}