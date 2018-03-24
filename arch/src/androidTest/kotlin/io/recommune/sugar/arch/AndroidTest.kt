package io.recommune.sugar.arch

import android.support.test.rule.ActivityTestRule
import org.junit.Rule


internal abstract class AndroidTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<SomeActivity>(SomeActivity::class.java)
}