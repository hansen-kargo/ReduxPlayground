package com.example.reduxplayground

import org.rekotlin.StateType

data class AppState(
    val counter: Int = 0,
    val testVar: String = "asdfasdf"
): StateType