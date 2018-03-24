package io.recommune.sugar.arch

import android.arch.lifecycle.LifecycleObserver
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class AndroidTestLifecycleObserver {

    private class SomeLifecycleObserver : LifecycleObserver

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<SomeActivity>(SomeActivity::class.java)

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