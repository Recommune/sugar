package io.recommune.sugar.preferences.gson

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import io.recommune.sugar.preferences.SharedPreferencesDelegate
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class AndroidTestConverterGson {


    companion object {

        private val gson = Gson()
        private val converter = ConverterGson(gson)

        private val itemValue = SomeItem("0")
        private val itemDefault = SomeItem("1")
    }

    private var SharedPreferences.item by SharedPreferencesDelegate.Item(itemDefault, converter, SomeItem::class)

    private data class SomeItem(@SerializedName("id") val id: String)

    private lateinit var preference: SharedPreferences

    @Before
    fun before() {
        val context = InstrumentationRegistry.getContext()
        preference = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
    }

    @After
    fun after() {
        preference.edit().clear().apply()
    }

    @Test
    fun item() {
        assertEquals(preference.item, itemDefault)
        preference.item = itemValue
        assertEquals(preference.item, itemValue)
    }
}