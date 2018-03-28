package io.recommune.sugar.core

import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlin.coroutines.experimental.CoroutineContext


abstract class BinderActor<T>(coroutineContext: CoroutineContext, default: Bind<T>? = null) : Binder<T> {

    override var state: Bind<T> = default ?: Bind.Detached()

    val actor: SendChannel<Bind<T>> = actor(coroutineContext) {
        consumeEach { message ->
            state = message
            handle(message)
        }
    }

    abstract override suspend fun handle(message: Bind<T>)
}