package com.pvv.calculator.logic

class Repository {
    val digitButtons = List(10){
        DigitButton('0'+it)
    }
    val separatorButton = SeparatorButton()

}