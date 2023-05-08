package com.pvv.calculator.logic

class SingleOperatorButton (override val caption : String,
  val operation : (Double) -> Double) :CalcButton {
    override fun operation(state: DataState): DataState {
        try {
           return state.copy(
              current = operation(state.current.toDoubleOrNull()?:0.0).toString(),
              isEmptyCurrent = false)
           }
        catch (E:RuntimeException){
            return state.copy(current = "ERROR",
                              isEmptyCurrent = true)
        }
    }
}