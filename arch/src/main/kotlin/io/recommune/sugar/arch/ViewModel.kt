package io.recommune.sugar.arch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity


inline fun <reified T : ViewModel> Fragment.viewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.viewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.viewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.viewModel(key: String, factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory).get(key, T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.viewModel(key: String, factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory).get(key, T::class.java)
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> viewModelFactory(crossinline factory: () -> T): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return factory() as T
        }
    }
}