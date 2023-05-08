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
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.weight(1f))
                        Indicator("TEST", Modifier)
                        Row2({}, Modifier)
                        Row1({}, Modifier)
                    }
                }
            }
        }
    }

}

@Composable
fun Row1(onClick:(calcButton:CalcButton)->Unit,
         modifier: Modifier ){
    Row(Modifier.fillMaxWidth()) {
        MainButton(CalcButton.DG_1, onClick, modifier.weight(1f))
        MainButton(CalcButton.DG_2, onClick, modifier.weight(1f))
        MainButton(CalcButton.DG_3, onClick, modifier.weight(1f))
        MainButton(CalcButton.PLUS, onClick, modifier.weight(1f))
    }
}

@Composable
fun Row2(onClick:(calcButton:CalcButton)->Unit,
         modifier: Modifier ){
    Row(Modifier.fillMaxWidth()) {
        MainButton(CalcButton.DG_4, onClick, modifier.weight(1f))
        MainButton(CalcButton.DG_5, onClick, modifier.weight(1f))
        MainButton(CalcButton.DG_6, onClick, modifier.weight(1f))
        MainButton(CalcButton.MINUS, onClick, modifier.weight(1f))
    }
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


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        Greeting("Android")
    }
}