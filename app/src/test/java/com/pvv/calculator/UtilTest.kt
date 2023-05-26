package com.pvv.calculator

import androidx.compose.ui.res.stringArrayResource
import com.pvv.calculator.logic.DataState
import com.pvv.calculator.ui.prevInfo
import org.junit.Assert
import org.junit.Test

class UtilTest {

    @Test
    fun prevInfoTest() {
       val state = DataState()
       val inf = prevInfo(state)
       Assert.assertEquals(inf,"")
    }

}