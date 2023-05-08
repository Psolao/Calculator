package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import org.junit.Assert
import org.junit.Test


class ButtonTest {
    val repo = Repository()

    @Test
    fun digitButtonTest() {
        val dataState = DataState()
        val bt1 = repo.digitButtons[1]
        val bt5 = repo.digitButtons[5]

        val dataStateAfter = dataState
            .let (bt1::operation)
            .let (bt5::operation)
            .let (bt1::operation)
            .let (bt5::operation)
        Assert.assertEquals("1515",dataStateAfter.current)
    }

    @Test
    fun digitWithSeparator (){
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val separatorButton = repo.separatorButton
        val dataStateAfter = dataState
            .let (bt6::operation)
            .let (bt9::operation)
            .let (separatorButton::operation)
            .let (bt9::operation)
        Assert.assertEquals("69"+separatorButton.caption+"9",dataStateAfter.current)
    }

    @Test
    fun digitWithSeparatorAndStart0 (){
        val dataState = DataState()
        val bt6 = repo.digitButtons[6]
        val bt9 = repo.digitButtons[9]
        val separatorButton = repo.separatorButton
        val dataStateAfter = dataState
            .let (separatorButton::operation)
            .let (bt6::operation)
            .let (bt9::operation)
            .let (bt9::operation)
        Assert.assertEquals("0"+separatorButton.caption+"699",dataStateAfter.current)
    }
}