package io.recommune.sugar.preferences

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


sealed class SharedPreferencesDelegate<T>(
    protected val default: T,
    protected val key: kotlin.String? = null
) : ReadWriteProperty<SharedPreferences, T> {

    class Boolean(default: kotlin.Boolean, key: kotlin.String? = null) : SharedPreferencesDelegate<kotlin.Boolean>(default, key) {

        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): kotlin.Boolean {
            return thisRef.getBoolean(key ?: property.name, default)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: kotlin.Boolean) {
            thisRef.edit().putBoolean(key ?: property.name, value).apply()
        }
    }

    class Int(default: kotlin.Int, key: kotlin.String? = null) : SharedPreferencesDelegate<kotlin.Int>(default, key) {

        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): kotlin.Int {
            return thisRef.getInt(key ?: property.name, default)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: kotlin.Int) {
            thisRef.edit().putInt(key ?: property.name, value).apply()
        }
    }

    class Long(default: kotlin.Long, key: kotlin.String? = null) : SharedPreferencesDelegate<kotlin.Long>(default, key) {

        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): kotlin.Long {
            return thisRef.getLong(key ?: property.name, default)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: kotlin.Long) {
            thisRef.edit().putLong(key ?: property.name, value).apply()
        }
    }

    class Float(default: kotlin.Float, key: kotlin.String? = null) : SharedPreferencesDelegate<kotlin.Float>(default, key) {

        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): kotlin.Float {
            return thisRef.getFloat(key ?: property.name, default)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: kotlin.Float) {
            thisRef.edit().putFloat(key ?: property.name, value).apply()
        }
    }

    class String(default: kotlin.String? = null, key: kotlin.String? = null) : SharedPreferencesDelegate<kotlin.String?>(default, key) {

        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): kotlin.String? {
            return thisRef.getString(key ?: property.name, default)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: kotlin.String?) {
            thisRef.edit().putString(key ?: property.name, value).apply()
        }
    }

    class StringSet(default: Set<kotlin.String>, key: kotlin.String? = null) : SharedPreferencesDelegate<Set<kotlin.String>>(default, key) {

        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): Set<kotlin.String> {
            return thisRef.getStringSet(key ?: property.name, default)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: Set<kotlin.String>) {
            thisRef.edit().putStringSet(key ?: property.name, value).apply()
        }
    }
}