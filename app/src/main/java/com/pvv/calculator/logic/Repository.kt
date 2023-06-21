package com.pvv.calculator.logic

class Repository {
    val digitButtons = List(10){
        DigitButton('0'+it)
    }
    val separatorButton = SeparatorButton()
    val executeButton = ExecuteButton()
    val invertButton = SingleStringOperatorButton ("+/-"){
        if (it=="0") it
        else {
            if (it[0] == '-')
                it.substring(1)
            else '-'+it
        }
    }

    val plusButton = DualOperatorButton(
        CalcOperation("+"){
            arg1, arg2 -> arg1 + arg2
        }
    )
    val minusButton = DualOperatorButton(
        CalcOperation("-"){
                arg1, arg2 -> arg1 - arg2
        }
    )

    val multButton = DualOperatorButton(
        CalcOperation("*"){
                arg1, arg2 -> arg1 * arg2
        }
    )

    val divButton = DualOperatorButton(
        CalcOperation("/"){
                arg1, arg2 -> arg1 / arg2
        }
    )

    val multInvButton =
        SingleOperatorButton ("1/x"){
        1/it
    }

    val sqrButton =
        SingleOperatorButton ("x\u00b2"){
            it*it
        }

    val sqrtButton =
        SingleOperatorButton ("\u221Ax"){
            Math.sqrt(it)
        }

    val percButton =
        SingleOperatorButton ("%"){
            it/100.0
        }

    val resetButton = ResetButton()
    val resetAllButton = ResetAllButton()
    val backspaceButton = BackspaceButton()
    val memorySetButton = MemorySetButton()
    val memoryPlusButton = MemoryPlusButton()
    val memoryMinusButton = MemoryMinusButton()
    val memoryGetButton = MemoryGetButton()
    val memoryResetButton = MemoryResetButton()
}