package io.recommune.sugar.core


sealed class Bind {

    class Attached<out T>(val payload: T? = null) : Bind()

    class Detached<out T>(val item: T? = null) : Bind()

    suspend inline fun <reified T> isAttached(noinline completion: suspend (T) -> Unit) {
        when (this) {
            is Attached<*> -> completion(payload as T)
        }
    }

    suspend inline fun <reified T> isDetached(noinline completion: suspend (T) -> Unit) {
        when (this) {
            is Detached<*> -> completion(item as T)
        }
    }
}