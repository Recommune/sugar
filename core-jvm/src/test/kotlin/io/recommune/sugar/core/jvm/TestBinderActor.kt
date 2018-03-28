package io.recommune.sugar.core.jvm

import io.recommune.sugar.core.Bind
import io.recommune.sugar.core.BinderActor
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.channels.sendBlocking
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.test.Test
import kotlin.test.assertEquals


@RunWith(JUnit4::class)
class TestBinderActor {

    companion object {

        const val string = "string"
        const val int = 0
    }

    @Test
    fun attached() {
        val deferred = CompletableDeferred<Boolean>()
        val binder = object : BinderActor<String>(EmptyCoroutineContext, Bind.Detached(Unit)) {

            override suspend fun handle(message: Bind) {
                message.isAttached<String> {
                    deferred.complete(state is Bind.Attached<*>)
                }
            }
        }
        assertEquals(true, binder.state is Bind.Detached<*>)
        val attached = runBlocking {
            withTimeout(1000L) {
                binder.actor.sendBlocking(Bind.Attached(string))
                deferred.await()
            }
        }
        assertEquals(true, attached)
    }

    @Test
    fun detached() {
        val deferred = CompletableDeferred<Boolean>()
        val binder = object : BinderActor<String>(EmptyCoroutineContext, Bind.Attached(Unit)) {

            override suspend fun handle(message: Bind) {
                message.isDetached<Int> {
                    deferred.complete(state is Bind.Detached<*> && it == int)
                }
            }
        }
        assertEquals(true, binder.state is Bind.Attached<*>)
        val detached = runBlocking {
            withTimeout(1000L) {
                binder.actor.sendBlocking(Bind.Detached(int))
                deferred.await()
            }
        }
        assertEquals(true, detached)
    }
}