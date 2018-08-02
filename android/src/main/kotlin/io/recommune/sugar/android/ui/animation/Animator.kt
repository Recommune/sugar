package io.recommune.sugar.android.ui.animation

import android.animation.Animator


fun Animator.addListener(
    start: ((Animator) -> Unit)? = null,
    end: ((Animator) -> Unit)? = null,
    cancel: ((Animator) -> Unit)? = null,
    repeat: ((Animator) -> Unit)? = null
) {
    addListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {
            start?.invoke(animation)
        }

        override fun onAnimationEnd(animation: Animator) {
            end?.invoke(animation)
        }

        override fun onAnimationCancel(animation: Animator) {
            cancel?.invoke(animation)
        }

        override fun onAnimationRepeat(animation: Animator) {
            repeat?.invoke(animation)
        }
    })
}