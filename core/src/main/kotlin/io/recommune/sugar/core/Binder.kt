package io.recommune.sugar.core


sealed class Binder<out T> {

    class Attached<out T>(val payload: T) : Binder<T>()

    class Detached<out T>(val payload: T) : Binder<T>()

    fun isAttached(completion: (T) -> Unit) {
        when (this) {
            is Attached -> completion(payload)
        }
    }

    fun isDetached(completion: (T) -> Unit) {
        when (this) {
            is Detached -> completion(payload)
        }
    }
}