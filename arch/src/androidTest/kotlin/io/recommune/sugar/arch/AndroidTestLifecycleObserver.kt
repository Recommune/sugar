package io.recommune.sugar.arch

import android.arch.lifecycle.LifecycleObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class AndroidTestLifecycleObserver : AndroidTest() {

    private class SomeLifecycleObserver : LifecycleObserver

    @Test
    fun addObserver() {
        activityTestRule.activity.apply {
            SomeLifecycleObserver()
                .addObserver(this)
                .removeObserver(this)
        }
    }

    @Test
    fun plusAssignObserver() {
        activityTestRule.activity += SomeLifecycleObserver()
    }

    @Test
    fun removeObserver() {
        SomeLifecycleObserver().addObserver(activityTestRule.activity)
    }

    @Test
    fun currentState() {
        activityTestRule.activity.currentState
    }
}