package com.pvv.calculator

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pvv.calculator.logic.CalcButton


@Composable
fun MainButton(calcButton: CalcButton,
               onClick : (CalcButton) -> Unit,
               modifier:Modifier = Modifier
){
    TextButton(
        onClick = {onClick(calcButton)},
        shape = Shapes.Full) {
        Text(text = calcButton.caption,
            style = MaterialTheme.typography.bodyLarge)
    }
}


