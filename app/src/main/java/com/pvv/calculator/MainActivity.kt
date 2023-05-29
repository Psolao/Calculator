package com.pvv.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pvv.calculator.logic.DataState
import com.pvv.calculator.ui.Indicator
import com.pvv.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     MainScreen()
                   }
                }
            }
        }
    }

    @Composable
    fun MainScreen(
        modifier: Modifier = Modifier,
        calcViewModel: CalcViewModel = viewModel()
    ){
        val dataState = calcViewModel
            .uiState
            .collectAsState(
                initial = DataState()
            )
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1f))
                        Indicator(Modifier, dataState.value)
                        Row3(Modifier, calcViewModel)
                        Row2(Modifier, calcViewModel)
                        Row1(Modifier, calcViewModel)
                        Row0(Modifier, calcViewModel)
        }

    }

@Composable
fun Row0(modifier: Modifier = Modifier,
         viewModel: CalcViewModel =viewModel(),
         ){
    Row(Modifier.fillMaxWidth()) {
        val buttonModifier = modifier.weight(weight = 1f, fill = true)
        MainButton(viewModel.repository.invertButton, viewModel::onButtonPress, buttonModifier)
        MainButton(viewModel.repository.digitButtons[0], viewModel::onButtonPress, buttonModifier)
        MainButton(viewModel.repository.separatorButton, viewModel::onButtonPress, buttonModifier)
        MainButton(viewModel.repository.executeButton, viewModel::onButtonPress, buttonModifier)
    }
}

@Composable
fun Row1(modifier: Modifier = Modifier,
         viewModel: CalcViewModel =viewModel(),
         ){
    Row(Modifier.fillMaxWidth()) {
        val buttonModifier = modifier.weight(weight = 1f, fill = true)
        MainButton(viewModel.repository.digitButtons[1], viewModel::onButtonPress, buttonModifier)
        MainButton(viewModel.repository.digitButtons[2], viewModel::onButtonPress, buttonModifier)
        MainButton(viewModel.repository.digitButtons[3], viewModel::onButtonPress, buttonModifier)
        MainButton(viewModel.repository.plusButton, viewModel::onButtonPress, buttonModifier)
    }
}

@Composable
fun Row2(modifier: Modifier = Modifier,
         viewModel: CalcViewModel =viewModel(),
         ){
    Row(Modifier.fillMaxWidth()) {
        MainButton(viewModel.repository.digitButtons[4], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[5], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[6], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.minusButton, viewModel::onButtonPress, modifier.weight(1f))    }
}

@Composable
fun Row3(modifier: Modifier = Modifier,
         viewModel: CalcViewModel =viewModel(),
         ){
    Row(Modifier.fillMaxWidth()) {
        MainButton(viewModel.repository.digitButtons[7], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[8], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[9], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.multButton, viewModel::onButtonPress, modifier.weight(1f))    }
}

@Preview
@Composable
fun TestRow1(){
    Row1()
}



