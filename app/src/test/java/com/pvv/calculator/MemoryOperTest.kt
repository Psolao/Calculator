package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import com.pvv.calculator.logic.decimalSeparator
import org.junit.Assert
import org.junit.Test

class MemoryOperTest {
    val repo = Repository()
    val delta = 1e-7

    @Test
    fun setMemory(){
        val dataState = DataState()
        val dateStateAfter =
            dataState
                .let (repo.digitButtons[5]::operation)
                .let (repo.digitButtons[2]::operation)
                .let (repo.memorySetButton::operation)
        Assert.assertEquals(52.0,dateStateAfter.memory?:0.0, delta )
    }

    @Test
    fun plusMemory(){
        val dataState = DataState()
        val dateStateAfter =
            dataState
                .let (repo.digitButtons[5]::operation)
                .let (repo.digitButtons[2]::operation)
                .let (repo.memoryPlusButton::operation)
                .let (repo.digitButtons[5]::operation)
                .let (repo.digitButtons[2]::operation)
                .let (repo.memoryPlusButton::operation)
        Assert.assertEquals("52",dateStateAfter.current )
        Assert.assertEquals(104.0,dateStateAfter.memory?:0.0 , delta )
    }

    @Test
    fun minusMemory(){
        val dataState = DataState()
        val dateStateAfter =
            dataState
                .let (repo.digitButtons[5]::operation)
                .let (repo.digitButtons[2]::operation)
                .let (repo.memoryMinusButton::operation)
                .let (repo.digitButtons[2]::operation)
                .let (repo.digitButtons[5]::operation)
                .let (repo.memoryPlusButton::operation)
        Assert.assertEquals("25",dateStateAfter.current )
        Assert.assertEquals(-27.0,dateStateAfter.memory?:0.0 , delta )
    }


    @Test
    fun getMemory(){
        val dataState = DataState(memory = 45.2)
        val dateStateAfter =
            dataState
                .let (repo.memoryGetButton::operation)
        Assert.assertEquals("45${decimalSeparator}2",dateStateAfter.current )
    }

    @Test
    fun getNotExistingMemory(){
        val dataState = DataState(current = "44")
        val dateStateAfter =
            dataState
                .let (repo.memoryGetButton::operation)
        Assert.assertEquals("44",dateStateAfter.current )
    }

    @Test
    fun resetMemory(){
        val dataState = DataState(memory = 45.2)
        val dateStateAfter =
            dataState
                .let (repo.memoryResetButton::operation)
        Assert.assertNull(dateStateAfter.memory)
    }


}
