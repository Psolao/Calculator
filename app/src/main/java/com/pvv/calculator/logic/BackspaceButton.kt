package com.pvv.calculator.logic

class BackspaceButton :CalcButton {
    override val caption: String
        get() = "<-"

    override fun operation(state: DataState): DataState {
        if (state.isEmptyCurrent || state.current.isEmpty())
              return state
        return state.copy(state.current.substring(0,state.current.lastIndex))
    }
}