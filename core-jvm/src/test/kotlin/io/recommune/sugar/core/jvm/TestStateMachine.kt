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
        val deferred = CompletableDeferred<Binder<String>>()
        val stateMachine = object : StateMachine<Binder<String>>(Binder.Detached(stringDefault)) {

            override fun handle(bind: Binder<String>) {
                bind.isAttached {
                    deferred.complete(bind)
                }
            }
        }
        val state = stateMachine.state
        when (state) {
            is Binder.Attached -> {
                assertFails { }
            }
            is Binder.Detached -> {
                assertEquals(state.payload, stringDefault)
            }
        }
        stateMachine.state = Binder.Attached(stringValue)
        val bind = runBlocking {
            withTimeout(1000L) {
                stateMachine.state = Binder.Attached(stringValue)
                deferred.await()
            }
        }
        when (bind) {
            is Binder.Attached -> {
                assertEquals(stringValue, bind.payload)
            }
            is Binder.Detached -> {
                assertFails { }
            }
        }
    }

    @Test
    fun detached() {
        val deferred = CompletableDeferred<Binder<Int>>()
        val stateMachine = object : StateMachine<Binder<Int>>(Binder.Attached(intDefault)) {

            override fun handle(bind: Binder<Int>) {
                bind.isDetached {
                    deferred.complete(bind)
                }
            }
        }

        val state = stateMachine.state
        when (state) {
            is Binder.Attached -> {
                assertEquals(state.payload, intDefault)
            }
            is Binder.Detached -> {
                assertFails { }
            }
        }
        val bind = runBlocking {
            withTimeout(1000L) {
                stateMachine.state = Binder.Detached(intValue)
                deferred.await()
            }
        }
        when (bind) {
            is Binder.Attached -> {
                assertFails { }
            }
            is Binder.Detached -> {
                assertEquals(intValue, bind.payload)
            }
        }
    }
}