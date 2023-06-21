package com.pvv.calculator

import com.pvv.calculator.logic.CalcOperation
import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.decimalSeparator
import com.pvv.calculator.ui.prevInfo
import org.junit.Assert
import org.junit.Test

class UtilTest {

    @Test
    fun prevInfoTestEmpty() {
       val state = DataState()
       val inf = prevInfo(state)
       Assert.assertEquals("", inf)
    }

    @Test
    fun prevInfoTestInt() {
        val state = DataState(previous = 5.0,
                              operation = CalcOperation("+"){
                                      arg1, arg2 -> arg1 + arg2
                              }
        )
        val inf = prevInfo(state)
        Assert.assertEquals("5+", inf)
    }

    @Test
    fun prevInfoTestDouble() {
        val state = DataState(previous = 4.8,
            operation = CalcOperation("*"){
                    arg1, arg2 -> arg1 * arg2
            }
        )
        val inf = prevInfo(state)
        Assert.assertEquals("4${decimalSeparator}8*", inf)
    }

    @Test
    fun prevInfoTestNoOper() {
        val state = DataState(previous = 4.8,
            operation = null
        )
        val inf = prevInfo(state)
        Assert.assertEquals("4${decimalSeparator}8", inf)
    }

}