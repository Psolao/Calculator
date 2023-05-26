package com.pvv.calculator.logic

class ExecuteButton:CalcButton {
    override val caption: String
        get() = "="

    override fun operation(state: DataState): DataState {
        if (state.operation==null) return state
        return try {
            val result = state.operation.oper(state.previous ?: 0.0, state.getDoubleCurrent())
            state.copy(current = doubleOrIntToStr(result)!!,
                         previous = result,
                         operation = null,
                         isEmptyCurrent = true )
        }
        catch (e:RuntimeException){
            state.copy(current = "ERROR",
                isEmptyCurrent = true)
        }
    }

}