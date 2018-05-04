package io.recommune.sugar.android

import android.view.View
import android.view.ViewGroup


interface AndroidView<T: View> {

    val view: T

    interface Inflater {

        val layoutId: Int

        fun inflate(parent: ViewGroup, attachToRoot: Boolean = false): View {
            return parent.inflate(layoutId, attachToRoot)
        }
    }
}
