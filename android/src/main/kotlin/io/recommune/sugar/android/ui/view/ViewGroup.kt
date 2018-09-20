package io.recommune.sugar.android.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

inline fun <reified T> ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): T {
    return inflate(layoutId, attachToRoot) as T
}