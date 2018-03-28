package io.recommune.sugar.core

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals


class TestBinderActor {

    companion object {

        const val attached = "attached"
    }

    @Test
    fun test() {
        val binder = object : BinderActor<String>(Job()) {

            override suspend fun handle(message: Bind<String>) {
                message.isAttached {
                    assertEquals(attached, it)
                    assertEquals(true, state is Bind.Attached)
                }
                message.isDetached {
                    assertEquals(true, state is Bind.Detached)
                }
            }
        }
        assertEquals(true, binder.state is Bind.Detached)
        runBlocking {
            binder.actor.send(Bind.Attached(attached))
            binder.actor.send(Bind.Detached())
        }
    }
}