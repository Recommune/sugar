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
        activityTestRule.activity.apply {
            val factory1 = viewModelFactory { SomeViewModel(id1) }
            val factory2 = viewModelFactory { SomeViewModel(id2) }
            val viewModel1 = viewModel<SomeViewModel>(id1, factory1)
            val viewModel2 = viewModel<SomeViewModel>(id2, factory2)
            val viewModel3 = viewModel<SomeViewModel>(id1, factory1)

            assertEquals(id1, viewModel1.id)
            assertEquals(id2, viewModel2.id)
            assertNotEquals(viewModel1, viewModel2)
            assertEquals(viewModel1, viewModel3)
        }
    }

    @Test
    fun androidViewModel() {
        activityTestRule.activity.apply {
            val application = application as SomeApplication
            val factory1 = viewModelFactory { SomeAndroidViewModel(application, id1) }
            val factory2 = viewModelFactory { SomeAndroidViewModel(application, id2) }
            val viewModel1 = viewModel<SomeAndroidViewModel>(id1, factory1)
            val viewModel2 = viewModel<SomeAndroidViewModel>(id2, factory2)
            val viewModel3 = viewModel<SomeAndroidViewModel>(id1, factory1)

            assertEquals(id1, viewModel1.id)
            assertEquals(id2, viewModel2.id)
            assertEquals(application, viewModel1.getApplication())
            assertNotEquals(viewModel1, viewModel2)
            assertEquals(viewModel1, viewModel3)
        }
    }
}