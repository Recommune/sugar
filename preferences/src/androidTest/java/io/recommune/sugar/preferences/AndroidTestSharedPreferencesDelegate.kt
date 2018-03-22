package io.recommune.sugar.preferences

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(AndroidJUnit4::class)
class AndroidTestSharedPreferencesDelegate {

    companion object {

        private const val booleanValue = false
        private const val booleanDefault = true
        private const val intValue = 1
        private const val intDefault = 2
        private const val longValue = 1L
        private const val longDefault = 2L
        private const val floatValue = 1f
        private const val floatDefault = 2f
        private const val stringValue = "value"
        private const val stringDefault = "default"

        private val stringSetValue = setOf(stringValue, stringDefault)
        private val stringSetDefault = setOf<String>()
    }

    private lateinit var preference: SharedPreferences

    private var SharedPreferences.boolean by SharedPreferencesDelegate.Boolean(booleanDefault)
    private var SharedPreferences.int by SharedPreferencesDelegate.Int(intDefault)
    private var SharedPreferences.long by SharedPreferencesDelegate.Long(longDefault)
    private var SharedPreferences.float by SharedPreferencesDelegate.Float(floatDefault)
    private var SharedPreferences.string by SharedPreferencesDelegate.String(stringDefault)
    private var SharedPreferences.stringSet by SharedPreferencesDelegate.StringSet(stringSetDefault)

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
    fun boolean() {
        assertEquals(booleanDefault, preference.boolean)
        preference.boolean = booleanValue
        assertEquals(booleanValue, preference.boolean)
    }

    @Test
    fun int() {
        assertEquals(intDefault, preference.int)
        preference.int = intValue
        assertEquals(intValue, preference.int)
    }

    @Test
    fun long() {
        assertEquals(longDefault, preference.long)
        preference.long = longValue
        assertEquals(longValue, preference.long)
    }

    @Test
    fun float() {
        assertEquals(floatDefault, preference.float)
        preference.float = floatValue
        assertEquals(floatValue, preference.float)
    }

    @Test
    fun stringSet() {
        assertEquals(stringSetDefault, preference.stringSet)
        preference.stringSet = stringSetValue
        assertEquals(stringSetValue, preference.stringSet)
    }

    @Test
    fun string() {
        assertEquals(stringDefault, preference.string)
        preference.string = stringValue
        assertEquals(stringValue, preference.string)
    }
}