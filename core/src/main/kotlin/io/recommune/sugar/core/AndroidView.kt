package io.recommune.sugar.core

import android.view.View
import android.view.ViewGroup


interface AndroidView {

    val view: View

    interface Inflater {

        val layoutId: Int

        fun inflate(parent: ViewGroup, attachToRoot: Boolean = false): View {
            return parent.inflate(layoutId, attachToRoot)
        }
    }
}
