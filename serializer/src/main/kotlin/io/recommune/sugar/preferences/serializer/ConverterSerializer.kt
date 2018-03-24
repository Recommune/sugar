package io.recommune.sugar.preferences.serializer

import io.recommune.sugar.preferences.SharedPreferencesDelegate
import kotlinx.serialization.json.JSON
import kotlinx.serialization.serializer
import kotlin.reflect.KClass


class ConverterSerializer(private val json: JSON) : SharedPreferencesDelegate.Converter {

    override fun <T : Any> toString(src: T, clazz: KClass<T>): String {
        return json.stringify(clazz.serializer(), src)
    }

    override fun <T : Any> fromString(src: String?, clazz: KClass<T>): T? {
        return if (src != null) json.parse(clazz.serializer(), src) else null
    }
}