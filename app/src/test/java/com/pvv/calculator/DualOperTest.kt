package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
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
         Assert.assertEquals("6.9", dataStateAfter.current)
         Assert.assertEquals(0.0, dataStateAfter.getDoubleCurrent(), delta)
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
        Assert.assertEquals("15.9", dataStateAfter.current)
        Assert.assertEquals(0.0, dataStateAfter.getDoubleCurrent(), delta)
    }


}