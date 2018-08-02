package io.recommune.sugar.android.ui.view

import android.view.View


fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun Boolean.toVisibility() = if (this) View.VISIBLE else View.GONE