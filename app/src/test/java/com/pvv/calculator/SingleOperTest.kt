package com.pvv.calculator

import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.Repository
import org.junit.Assert
import org.junit.Test

class SingleOperTest {

    val repo =Repository()

    @Test
    fun testNegWithSepartor(){
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

}