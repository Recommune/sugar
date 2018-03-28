package io.recommune.sugar.preferences.serializer

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.recommune.sugar.preferences.SharedPreferencesDelegate
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(AndroidJUnit4::class)
internal class AndroidTestConverterSerializer {

    companion object {

        private val itemValue = SomeItem("0")
        private val itemDefault = SomeItem("1")
        private val converter = ConverterSerializer(JSON.plain)
    }

    private lateinit var preference: SharedPreferences

    private var SharedPreferences.item by SharedPreferencesDelegate.Item(itemDefault, converter, SomeItem::class)
    private var SharedPreferences.itemNoDefault by SharedPreferencesDelegate.ItemNullable(null, converter, SomeItem::class)

    @Serializable
    private data class SomeItem(val id: String)

    @Before
    fun before() {
        val context = InstrumentationRegistry.getContext()
        preference = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
    }

    @Test
    fun item() {
        assertEquals(itemDefault, preference.item)
        preference.item = itemValue
        assertEquals(itemValue, preference.item)
    }

    @Test
    fun itemDefault() {
        assertEquals(preference.itemNoDefault, null)
        preference.itemNoDefault = itemValue
        assertEquals(preference.itemNoDefault, itemValue)
        preference.itemNoDefault = null
        assertEquals(preference.itemNoDefault, null)
    }
}