package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import com.pvv.calculator.logic.decimalSeparator
import org.junit.Assert
import org.junit.Test

class DualOperTest {
    val repo = Repository()
    val delta =1e-7
    @Test
    fun testOper(){
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val separatorBtn = repo.separatorButton
        val plusBtn = repo.plusButton
        val dataStateAfter =
            dataState
                .let(bt6::operation)
                .let(separatorBtn::operation)
                .let(bt9::operation)
                .let(plusBtn::operation)

         Assert.assertEquals(6.9, dataStateAfter.previous ?: 0.0, delta)
         Assert.assertTrue(dataStateAfter.isEmptyCurrent)
         Assert.assertEquals("6${decimalSeparator}9", dataStateAfter.current)
    }

    @Test
    fun testplus(){
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val separatorBtn = repo.separatorButton
        val plusBtn = repo.plusButton
        val executeButton = repo.executeButton
        val dataStateAfter =
            dataState
                .let(bt6::operation)
                .let(separatorBtn::operation)
                .let(bt9::operation)
                .let(plusBtn::operation)
                .let(bt9::operation)
                .let(executeButton::operation)

        Assert.assertEquals(15.9, dataStateAfter.previous ?: 0.0, delta)
        Assert.assertTrue(dataStateAfter.isEmptyCurrent)
        Assert.assertEquals("15${decimalSeparator}9", dataStateAfter.current)
    }


    @Test
    fun testDiv(){
        val dataState = DataState()
        val dataStateAfter =
            dataState
                .let(repo.digitButtons[6]::operation)
                .let(repo.divButton::operation)
                .let(repo.digitButtons[4]::operation)
                .let(repo.executeButton::operation)

        Assert.assertEquals(1.5, dataStateAfter.getDoubleCurrent(), delta)
    }


}