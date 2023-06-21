package com.pvv.calculator.logic

class MemorySetButton : CalcButton {
    override val caption: String
        get() = "MS"

    override fun operation(state: DataState): DataState {
        return state.copy(memory = state.getDoubleCurrent(), isEmptyCurrent = true)
    }
}

class MemoryPlusButton : CalcButton {
    override val caption: String
        get() = "M+"

    override fun operation(state: DataState): DataState {
        return state.copy(
            memory = (state.memory ?: 0.0) + state.getDoubleCurrent(),
            isEmptyCurrent = true,
        )
    }
}

class MemoryMinusButton : CalcButton {
    override val caption: String
        get() = "M-"

    override fun operation(state: DataState): DataState {
        return state.copy(
            memory = (state.memory ?: 0.0) - state.getDoubleCurrent(),
            isEmptyCurrent = true,
        )
    }
}


class MemoryResetButton : CalcButton {
    override val caption: String
        get() = "MC"

    override fun operation(state: DataState): DataState {
        return state.copy(memory = null, isEmptyCurrent = true)
    }
}


class MemoryGetButton : CalcButton {
    override val caption: String
        get() = "MR"

    override fun operation(state: DataState): DataState {
        if (state.memory == null) return state
        return state.copy(current = doubleOrIntToStr(state.memory) ?: "0", isEmptyCurrent = true)
    }
}