package io.recommune.sugar.core


interface Binder<T> {

    var state: Bind<T>

    suspend fun handle(message: Bind<T>)
}