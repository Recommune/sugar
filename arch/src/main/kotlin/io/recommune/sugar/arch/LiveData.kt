package io.recommune.sugar.arch

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer


inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline completion: (T?) -> Unit) {
    observe(owner, Observer { data -> completion(data) })
}

inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, crossinline completion: (T) -> Unit) {
    observe(owner, Observer { data -> if (data != null) completion(data) })
}