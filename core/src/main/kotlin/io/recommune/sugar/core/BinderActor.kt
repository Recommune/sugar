package io.recommune.sugar.core

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach


abstract class BinderActor<T>(job: Job) : Binder<T> {

    override var state: Bind<T> = Bind.Detached()

    val actor: SendChannel<Bind<T>> = actor(job) {
        consumeEach { message ->
            state = message
            handle(message)
        }
    }

    abstract override suspend fun handle(message: Bind<T>)
}