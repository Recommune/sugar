package io.recommune.sugar.arch

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


@RunWith(AndroidJUnit4::class)
internal class AndroidTestViewModel {

    companion object {

        private const val id1 = "id1"
        private const val id2 = "id2"
    }

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<SomeActivity>(SomeActivity::class.java)

    @Test
    fun viewModel() {
        val viewModel1 = getViewModelConstructor(id1)
        val viewModel2 = getViewModelConstructor(id2)
        val viewModel3 = getViewModelConstructor(id1)

        assertEquals(id1, viewModel1.id)
        assertEquals(id2, viewModel2.id)
        assertNotEquals(viewModel1, viewModel2)
        assertEquals(viewModel1, viewModel3)
    }

    @Test
    fun androidViewModel() {
        val viewModel1 = getAndroidViewModelConstructor(id1)
        val viewModel2 = getAndroidViewModelConstructor(id2)
        val viewModel3 = getAndroidViewModelConstructor(id1)
        val application = getApplication()

        assertEquals(id1, viewModel1.id)
        assertEquals(id2, viewModel2.id)
        assertEquals(application, viewModel1.getApplication())
        assertNotEquals(viewModel1, viewModel2)
        assertEquals(viewModel1, viewModel3)
    }

    private fun getApplication(): SomeApplication {
        return activityTestRule.activity.application as SomeApplication
    }

    private fun getViewModelConstructor(id: String): SomeViewModelConstructor {
        return activityTestRule.activity.viewModel(id, viewModelFactory { SomeViewModelConstructor(id) })
    }

    private fun getAndroidViewModelConstructor(id: String): SomeAndroidViewModelConstructor {
        val application = getApplication()
        return activityTestRule.activity.viewModel(id, viewModelFactory { SomeAndroidViewModelConstructor(application, id) })
    }
}