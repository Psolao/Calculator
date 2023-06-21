package com.pvv.calculator.logic

import java.text.DecimalFormatSymbols
import kotlin.math.abs

val decimalSeparator = DecimalFormatSymbols().decimalSeparator
class CalcOperation (
   val caption : String,
   val oper : (Double, Double) -> Double,
   )

data class DataState (
    val current : String = "0",
    val previous : Double? = null,
    val operation : CalcOperation? = null,
    val memory : Double? = null,
    var isEmptyCurrent :Boolean = false
){
    fun getStringCurrent():String = if (isEmptyCurrent) "0" else current
    fun getDoubleCurrent():Double = current.replace(decimalSeparator,'.').toDoubleOrNull() ?: 0.0

}

fun doubleOrIntToStr(arg:Double?):String?{
    if (arg==null) return null
    val frac = arg % 1
    return if (abs(frac) <1e-8) {
        arg.toLong().toString()
    }
    else{
        arg.toString().replace('.', decimalSeparator)
    }
}
