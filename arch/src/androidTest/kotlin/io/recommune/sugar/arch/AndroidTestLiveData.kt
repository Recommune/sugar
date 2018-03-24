package io.recommune.sugar.arch

import android.arch.lifecycle.MutableLiveData
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
internal class AndroidTestLiveData : AndroidTest() {

    companion object {

        const val value1 = "value1"
        const val value2 = "value2"
    }

    private val liveData = MutableLiveData<String>()

    @Test
    fun observe() {
        liveData.observe(activityTestRule.activity) { string ->
            assertEquals(value1, string)
        }
        liveData.postValue(value1)
    }

    @Test
    fun observeNotNull() {
        liveData.observeNotNull(activityTestRule.activity) { string ->
            assertEquals(value2, string)
        }
        liveData.postValue(value2)
    }
}