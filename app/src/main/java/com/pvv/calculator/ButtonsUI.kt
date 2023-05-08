package com.pvv.calculator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MainButton(calcButton: CalcButton,
           onClick: (CalcButton)-> Unit,
           modifier: Modifier
){
    TextButton(
        onClick = {onClick(calcButton)},
        modifier = modifier,
        shape = Shapes.Full) {
        Text(text = calcButton.text,
            style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview
@Composable
fun testButton(){
    MainButton(calcButton = CalcButton.DG_1,
    onClick = {},
    modifier = Modifier)
}