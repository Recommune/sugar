package io.recommune.sugar.preferences.serializer

import io.recommune.sugar.preferences.SharedPreferencesDelegate
import kotlinx.serialization.json.JSON
import kotlinx.serialization.serializer
import kotlin.reflect.KClass


class ConverterSerializer : SharedPreferencesDelegate.Converter {

    override fun <T : Any> toString(src: T, clazz: KClass<T>): String {
        return JSON.stringify(clazz.serializer(), src)
    }

    override fun <T : Any> fromString(src: String?, clazz: KClass<T>): T? {
        return if (src != null) JSON.parse(clazz.serializer(), src) else null
    }
}