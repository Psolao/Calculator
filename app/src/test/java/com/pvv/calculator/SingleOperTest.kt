package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import com.pvv.calculator.logic.decimalSeparator
import org.junit.Assert
import org.junit.Test

class SingleOperTest {

    val repo =Repository()

    @Test
    fun testNegWithSeparator(){
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val separatorBtn = repo.separatorButton
        val invertBtn = repo.invertButton

        val dataStateAfter =
             dataState
                  .let(bt6::operation)
                  .let(separatorBtn::operation)
                  .let(invertBtn::operation)
                  .let(bt9::operation)
         Assert.assertEquals("-6"+separatorBtn.caption+"9", dataStateAfter.getStringCurrent())
    }

    @Test
    fun testResetAfterSingleOper (){
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val multInvertBtn = repo.multInvButton
        val dataStateAfter =
            dataState
                .let(bt6::operation)
                .let(multInvertBtn::operation)
                .let(bt6::operation)
                .let(bt6::operation)
        Assert.assertEquals("66", dataStateAfter.getStringCurrent())
    }

    @Test
    fun testMultInv(){
        val dataState = DataState()
        val bt2 = repo.digitButtons[2]
        val multInvertBtn = repo.multInvButton

        val dataStateAfter =
            dataState
                .let(bt2::operation)
                .let(multInvertBtn::operation)
        Assert.assertEquals(0.5, dataStateAfter.getDoubleCurrent(), 1e-8)

        val dataStateAfter2 =
            dataStateAfter
                .let(multInvertBtn::operation)

        Assert.assertEquals(2.0, dataStateAfter2.getDoubleCurrent(), 1e-8)
    }

    @Test
    fun testSqr(){
        val dataState = DataState()
        val bt2 = repo.digitButtons[2]
        val sqrBtn = repo.sqrButton

        val dataStateAfter =
            dataState
                .let(bt2::operation)
                .let(sqrBtn::operation)
                .let(sqrBtn::operation)
        Assert.assertEquals(16.0, dataStateAfter.getDoubleCurrent(), 1e-8)
    }


    @Test
    fun testSqrt(){
        val dataState = DataState()
        val bt1 = repo.digitButtons[1]
        val bt6 = repo.digitButtons[6]
        val sqrtBtn = repo.sqrtButton

        val dataStateAfter =
            dataState
                .let(bt1::operation)
                .let(bt6::operation)
                .let(sqrtBtn::operation)
                .let(sqrtBtn::operation)
        Assert.assertEquals(2.0, dataStateAfter.getDoubleCurrent(), 1e-8)
    }

}