package com.example.reduxplayground

import org.rekotlin.Action

// all of the actions that can be applied to the state
data class CounterActionIncrease(val unit: Unit = Unit): Action
data class CounterActionDecrease(val unit: Unit = Unit): Action
data class CounterActionIncreaseMany(val howmany: Int): Action