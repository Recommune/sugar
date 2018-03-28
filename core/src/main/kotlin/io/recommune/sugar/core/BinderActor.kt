package io.recommune.sugar.core

import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlin.coroutines.experimental.CoroutineContext


abstract class BinderActor<T>(coroutineContext: CoroutineContext, default: Bind? = null) : Binder {

    override var state: Bind = default ?: Bind.Detached<T>()

    val actor: SendChannel<Bind> = actor(coroutineContext) {
        consumeEach { message ->
            state = message
            handle(message)
        }
    }

    abstract override suspend fun handle(message: Bind)
}