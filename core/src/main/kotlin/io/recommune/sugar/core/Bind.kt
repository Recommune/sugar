package io.recommune.sugar.core


sealed class Bind<out T> {

    class Attached<out T>(val view: T) : Bind<T>()

    class Detached<out T> : Bind<T>()

    suspend fun isAttached(completion: suspend (T) -> Unit) {
        when (this) {
            is Attached<T> -> completion(view)
        }
    }

    suspend fun isDetached(completion: suspend () -> Unit) {
        when (this) {
            is Detached<T> -> completion()
        }
    }
}