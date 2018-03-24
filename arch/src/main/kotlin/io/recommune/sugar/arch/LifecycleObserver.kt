package io.recommune.sugar.arch

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner


inline fun <reified T : LifecycleObserver> T.addObserver(owner: LifecycleOwner): T {
    owner.lifecycle.addObserver(this)
    return this
}

inline fun <reified T : LifecycleObserver> T.removeObserver(owner: LifecycleOwner): T {
    owner.lifecycle.removeObserver(this)
    return this
}

inline val LifecycleOwner.currentState get() = lifecycle.currentState