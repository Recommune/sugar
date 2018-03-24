package io.recommune.sugar.arch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity


inline fun <reified T : ViewModel> Fragment.viewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

inline fun <reified T: ViewModel> FragmentActivity.viewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}