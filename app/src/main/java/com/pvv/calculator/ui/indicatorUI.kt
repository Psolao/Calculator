package com.pvv.calculator.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pvv.calculator.CalcViewModel
import com.pvv.calculator.logic.DataState
import com.pvv.calculator.logic.doubleOrIntToStr
import com.pvv.calculator.ui.theme.indicatorStyle



@Composable
fun Indicator(modifier: Modifier = Modifier,
              viewModel: CalcViewModel = viewModel(),){
    val dataState = viewModel
        .uiState
        .collectAsState(
            initial = DataState()
        )
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = prevInfo(dataState.value),
            textAlign = TextAlign.Right,
            modifier = modifier.fillMaxWidth()
        )
        Text(text = dataState.value.current,
            textAlign = TextAlign.Right,
            modifier = modifier.fillMaxWidth(),
            style = indicatorStyle
        )
    }
}

fun prevInfo(dataState: DataState):String {
    return (doubleOrIntToStr(dataState.previous) ?: "") +
            (dataState.operation?.caption ?: "")
}

