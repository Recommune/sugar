package io.recommune.sugar.preferences.gson

import com.google.gson.Gson
import io.recommune.sugar.preferences.Converter
import kotlin.reflect.KClass


class ConverterGson(private val gson: Gson) : Converter {

    override fun <T : Any> toString(src: T, clazz: KClass<T>): String {
        return gson.toJson(src, clazz.javaObjectType)
    }

    override fun <T : Any> fromString(src: String?, clazz: KClass<T>): T? {
        return if (src != null) gson.fromJson(src, clazz.javaObjectType) else null
    }
}