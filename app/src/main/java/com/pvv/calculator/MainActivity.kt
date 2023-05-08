package com.pvv.calculator

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.ColorUtils
import androidx.lifecycle.viewmodel.compose.viewModel
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
        gameViewModel: CalcViewModel = viewModel()
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1f))
//                        Indicator("TEST", Modifier)
//                        Row2({}, Modifier)
//                        Row1({}, Modifier)
        }

    }

@Composable
fun Row1(viewModel: CalcViewModel =viewModel(),
         modifier: Modifier = Modifier){
    Row(Modifier.fillMaxWidth()) {
        MainButton(viewModel.repository.digitButtons[1], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[2], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[3], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.plusButton, viewModel::onButtonPress, modifier.weight(1f))
    }
}

@Composable
fun Row2(viewModel: CalcViewModel =viewModel(),
         modifier: Modifier = Modifier){
    Row(Modifier.fillMaxWidth()) {
        MainButton(viewModel.repository.digitButtons[4], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[5], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.digitButtons[6], viewModel::onButtonPress, modifier.weight(1f))
        MainButton(viewModel.repository.minusButton, viewModel::onButtonPress, modifier.weight(1f))    }
}

@Composable
fun Indicator(text:String, modifier: Modifier){
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = text,
            textAlign = TextAlign.Right,
            modifier = modifier.fillMaxWidth()
        )
    }
}




