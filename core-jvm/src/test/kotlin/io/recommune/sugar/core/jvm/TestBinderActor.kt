package io.recommune.sugar.core.jvm

import io.recommune.sugar.core.Bind
import io.recommune.sugar.core.BinderActor
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.channels.sendBlocking
import kotlinx.coroutines.experimental.runBlocking
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.test.Test
import kotlin.test.assertEquals


@RunWith(JUnit4::class)
class TestBinderActor {

    companion object {

        const val attached = "attached"
    }

    @Test
    fun attached() {
        val deferred = CompletableDeferred<Boolean>()
        val binder = object : BinderActor<String>(EmptyCoroutineContext, Bind.Detached()) {

            override suspend fun handle(message: Bind<String>) {
                message.isAttached {
                    deferred.complete(state is Bind.Attached)
                }
            }
        }
        assertEquals(true, binder.state is Bind.Detached)
        val attached = runBlocking {
            binder.actor.sendBlocking(Bind.Attached(attached))
            deferred.await()
        }
        assertEquals(true, attached)
    }

    @Test
    fun detached() {
        val deferred = CompletableDeferred<Boolean>()
        val binder = object : BinderActor<String>(EmptyCoroutineContext, Bind.Attached(attached)) {

            override suspend fun handle(message: Bind<String>) {
                message.isDetached {
                    deferred.complete(state is Bind.Detached)
                }
            }
        }
        assertEquals(true, binder.state is Bind.Attached)
        val detached = runBlocking {
            binder.actor.sendBlocking(Bind.Detached())
            deferred.await()
        }
        assertEquals(true, detached)
    }
}