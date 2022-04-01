package com.example.reduxplayground

import org.rekotlin.Action


// the reducer is responsible for evolving the application state based
// on the actions it receives
fun counterReducer(action: Action, state: AppState?): AppState {
    // if no state has been provided, create the default state
    var state = state ?: AppState()

    when(action){
        is CounterActionIncrease -> {
            state = state.copy(counter = state.counter + 1)
        }
        is CounterActionDecrease -> {
            state = state.copy(counter = state.counter - 1)
        }
        is CounterActionIncreaseMany -> {
            state = state.copy(counter = state.counter + action.howmany)
        }
    }

    return state
}