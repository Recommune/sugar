package io.recommune.sugar.core


sealed class Binder {

    class Attached<out T>(val payload: T) : Binder()

    class Detached<out T>(val payload: T) : Binder()
}