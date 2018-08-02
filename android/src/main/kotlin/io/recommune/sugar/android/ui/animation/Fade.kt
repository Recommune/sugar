package io.recommune.sugar.android.ui.animation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View


fun Drawable.fadeInSimple(context: Context): ValueAnimator =
    ValueAnimator.ofArgb(0, 255).also {
        it.duration = context.durationSimpleFadeIn
        it.addUpdateListener {
            alpha = it.animatedValue as Int
        }
    }

fun Drawable.fadeOutSimple(context: Context): ValueAnimator =
    ValueAnimator.ofArgb(255, 0).also {
        it.duration = context.durationSimpleFadeOut
        it.addUpdateListener {
            alpha = it.animatedValue as Int
        }
    }

fun View.fadeInSimple() = objectAnimatorAlpha(context.durationSimpleFadeIn, 0f, 1f)
fun View.fadeOutSimple() = objectAnimatorAlpha(context.durationSimpleFadeOut, 1f, 0f)