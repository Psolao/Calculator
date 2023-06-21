package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import org.junit.Assert
import org.junit.Test

class ResetTest {
    val repo = Repository()
    val delta =1e-7

    @Test
    fun ResetTest(){
       val dataState = DataState(memory = 5.4, current = "75", previous = 45.0 )
       val dataStateAfter =
            dataState
                .let(repo.resetButton::operation)
       Assert.assertEquals(0.0, dataStateAfter.getDoubleCurrent(), delta)
       Assert.assertTrue(dataStateAfter.isEmptyCurrent)
       Assert.assertEquals(dataState.previous, dataStateAfter.previous)
       Assert.assertEquals(dataState.memory, dataStateAfter.memory)
    }

    @Test
    fun ResetAllTest(){
        val dataState = DataState(memory = 5.4, current = "75", previous = 45.0 )
        val dataStateAfter =
            dataState
                .let(repo.resetAllButton::operation)
        Assert.assertEquals(0.0, dataStateAfter.getDoubleCurrent(), delta)
        Assert.assertTrue(dataStateAfter.isEmptyCurrent)
        Assert.assertNull(dataStateAfter.previous)
        Assert.assertEquals(dataState.memory, dataStateAfter.memory)
    }

    @Test
    fun ResetBackTest(){
        val dataState = DataState(memory = 5.4, current = "75.42", previous = 45.0 )
        val dataStateAfter =
            dataState
                .let(repo.backspaceButton::operation)
        Assert.assertEquals("75.4", dataStateAfter.current)
        val dataStateAfter2 =
            dataStateAfter
                .let(repo.backspaceButton::operation)
        Assert.assertEquals("75.", dataStateAfter2.current)
        Assert.assertEquals(75.0, dataStateAfter2.getDoubleCurrent(),delta)
    }

    @Test
    fun ResetTest2(){
        val dataState = DataState(memory = 5.4, current = "75", previous = 45.0 )
        val dataStateAfter =
            dataState
                .let(repo.resetButton::operation)
                .let(repo.digitButtons[2]::operation)
        Assert.assertEquals("2", dataStateAfter.current)
        Assert.assertFalse(dataStateAfter.isEmptyCurrent)
    }


}