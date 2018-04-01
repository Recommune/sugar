package io.recommune.sugar.core.jvm

import io.recommune.sugar.core.Binder
import io.recommune.sugar.core.StateMachine
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


@RunWith(JUnit4::class)
class TestStateMachine {

    companion object {

        const val stringDefault = "default"
        const val stringValue = "value"
        const val intDefault = 0
        const val intValue = 1
    }

    @Test
    fun attached() {
        val deferred = CompletableDeferred<Binder>()
        val stateMachine = object : StateMachine<Binder>(Binder.Detached(stringDefault)) {

            override fun handle(bind: Binder) {
                deferred.complete(bind)
            }
        }
        stateMachine.isState<Binder.Detached<String>> {
            assertEquals(it.payload, stringDefault)
            stateMachine.state = Binder.Attached(stringValue)
        }
        val bind = runBlocking {
            withTimeout(1000L) {
                deferred.await()
            }
        }
        when (bind) {
            is Binder.Attached<*> -> {
                assertEquals(stringValue, bind.payload)
            }
            is Binder.Detached<*> -> {
               assertFails {  }
            }
        }
    }

    @Test
    fun detached() {
        val deferred = CompletableDeferred<Binder>()
        val stateMachine = object : StateMachine<Binder>(Binder.Attached(intDefault)) {

            override fun handle(bind: Binder) {
                deferred.complete(bind)
            }
        }

        stateMachine.isState<Binder.Attached<Int>> {
            assertEquals(it.payload, intDefault)
            stateMachine.state = Binder.Detached(intValue)
        }
        val bind = runBlocking {
            withTimeout(1000L) {
                deferred.await()
            }
        }
        when (bind) {
            is Binder.Attached<*> -> {
                assertFails { }
            }
            is Binder.Detached<*> -> {
                assertEquals(intValue, bind.payload)
            }
        }
    }
}