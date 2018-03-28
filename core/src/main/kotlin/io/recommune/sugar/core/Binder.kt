package io.recommune.sugar.core


interface Binder {

    var state: Bind

    suspend fun handle(bind: Bind)
}