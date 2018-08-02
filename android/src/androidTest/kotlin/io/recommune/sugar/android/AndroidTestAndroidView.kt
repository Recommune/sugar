package io.recommune.sugar.android

import android.support.test.rule.ActivityTestRule
import android.view.View
import io.recommune.sugar.android.ui.view.AndroidView
import kotlinx.android.synthetic.main.activity.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals


@RunWith(JUnit4::class)
internal class AndroidTestAndroidView {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<SomeActivity>(SomeActivity::class.java)

    private class SomeAndroidView(override val view: View) : AndroidView<View> {

        companion object : AndroidView.Inflater {

            override val layoutId: Int = R.layout.view
        }
    }

    @Test
    fun attached() {
        activityTestRule.activity.apply {
            runOnUiThread {
                setContentView(R.layout.activity)
                val someView = SomeAndroidView(SomeAndroidView.inflate(container, true))
                assertEquals(true, someView.view.isAttachedToWindow)
            }
        }
    }

    @Test
    fun unAttached() {
        activityTestRule.activity.apply {
            runOnUiThread {
                setContentView(R.layout.activity)
                val someView = SomeAndroidView(SomeAndroidView.inflate(container))
                assertEquals(false, someView.view.isAttachedToWindow)
            }
        }
    }
}