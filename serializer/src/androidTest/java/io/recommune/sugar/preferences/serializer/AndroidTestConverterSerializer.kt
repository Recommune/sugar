package io.recommune.sugar.preferences.serializer

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import io.recommune.sugar.preferences.SharedPreferencesDelegate
import kotlinx.serialization.Serializable
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class AndroidTestConverterSerializer {

    companion object {

        private val itemValue = SomeItem("0")
        private val itemDefault = SomeItem("1")
        private val converter = ConverterSerializer()
    }

    private lateinit var preference: SharedPreferences

    private var SharedPreferences.item by SharedPreferencesDelegate.Item(itemDefault, converter, SomeItem::class)

    @Before
    fun before() {
        val context = InstrumentationRegistry.getContext()
        preference = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
    }

    @After
    fun after() {
        preference.edit().clear().apply()
    }

    @Serializable
    private data class SomeItem(val id: String)

    @Test
    fun item() {
        assertEquals(preference.item, itemDefault)
        preference.item = itemValue
        assertEquals(preference.item, itemValue)
    }
}