package io.recommune.sugar.preferences

import kotlin.reflect.KClass

interface Converter {

    fun <T : Any> toString(src: T, clazz: KClass<T>): kotlin.String

    fun <T : Any> fromString(src: kotlin.String?, clazz: KClass<T>): T?
}