package io.recommune.sugar.arch

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class AndroidTestViewModel {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<SomeActivity>(SomeActivity::class.java)

    @Before
    fun before() {

    }

    @Test
    fun viewModel() {
        activityTestRule.activity.viewModel<SomeViewModel>()
    }
}