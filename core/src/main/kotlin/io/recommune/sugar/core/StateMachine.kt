package io.recommune.sugar.core


abstract class StateMachine<T>(initialState: T) {

    var state: T = initialState
        set(value) {
            field = value
            handle(field)
        }

    abstract fun handle(bind: T)
}