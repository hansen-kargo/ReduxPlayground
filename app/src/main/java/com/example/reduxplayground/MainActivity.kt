package com.example.reduxplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.rekotlin.Action
import org.rekotlin.StateType
import org.rekotlin.Store
import org.rekotlin.StoreSubscriber

val mainStore = Store(
    reducer = ::counterReducer,
    state = null
)

class MainActivity : AppCompatActivity(), StoreSubscriber<AppState> {

    private val counterLabel: TextView by lazy {
        this.findViewById(R.id.counter_label) as TextView
    }

    private val buttonUp: Button by lazy {
        this.findViewById(R.id.button) as Button
    }

    private val buttonDown: Button by lazy {
        this.findViewById(R.id.button2) as Button
    }

    private val buttonUpMany: Button by lazy {
        this.findViewById(R.id.button3) as Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when either button is tapped, an action is dispatched to the store
        // in order to update the application state
        this.buttonUp.setOnClickListener {
            mainStore.dispatch(CounterActionIncrease())
        }
        this.buttonDown.setOnClickListener {
            mainStore.dispatch(CounterActionDecrease())
        }

        this.buttonUpMany.setOnClickListener {
            mainStore.dispatch(CounterActionIncreaseMany(10))
        }

        // subscribe to state changes
        mainStore.subscribe(this)
    }

    override fun newState(state: AppState) {
        // when the state changes, the UI is updated to reflect the current state
        this.counterLabel.text = "${state.counter}"
    }
}
