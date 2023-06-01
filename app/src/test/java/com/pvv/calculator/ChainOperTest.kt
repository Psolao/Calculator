package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import org.junit.Assert
import org.junit.Test

class ChainOperTest {
    val repo = Repository()

    @Test
    fun testChain() {
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val executeButton = repo.executeButton
        val plusBtn = repo.plusButton
        val dataStateAfter =
            dataState
                .let(bt6::operation)
                .let(plusBtn::operation)
                .let(bt9::operation)
                .let(plusBtn::operation)
                .let(bt9::operation)
                .let(executeButton::operation)

        Assert.assertEquals("24", dataStateAfter.current )
    }

    @Test
    fun testUsingResultInNextOper() {
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val executeButton = repo.executeButton
        val plusBtn = repo.plusButton
        val dataStateAfter =
            dataState
                .let(bt6::operation)
                .let(plusBtn::operation)
                .let(bt9::operation)
                .let(executeButton::operation)
                .let(plusBtn::operation)
                .let(bt9::operation)
                .let(executeButton::operation)

        Assert.assertEquals("24", dataStateAfter.current )

    }


}