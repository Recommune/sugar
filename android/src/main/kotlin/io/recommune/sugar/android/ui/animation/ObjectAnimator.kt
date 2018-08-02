package io.recommune.sugar.android.ui.animation

import android.animation.ObjectAnimator
import android.view.View


fun View.objectAnimatorFloat(property: String, duration: Long, vararg controls: Float): ObjectAnimator =
    ObjectAnimator.ofFloat(this, property, *controls).also {
        it.duration = duration
    }

fun View.objectAnimatorScaleX(duration: Long, vararg controls: Float) =
    objectAnimatorFloat("scaleX", duration, *controls)

fun View.objectAnimatorScaleY(duration: Long, vararg controls: Float): ObjectAnimator =
    objectAnimatorFloat("scaleY", duration, *controls)

fun View.objectAnimatorTranslationX(duration: Long, vararg controls: Float): ObjectAnimator =
    objectAnimatorFloat("translationX", duration, *controls)

fun View.objectAnimatorTranslationY(duration: Long, vararg controls: Float): ObjectAnimator =
    objectAnimatorFloat("translationY", duration, *controls)

fun View.objectAnimatorRotationX(duration: Long, vararg controls: Float): ObjectAnimator =
    objectAnimatorFloat("rotationX", duration, *controls)

fun View.objectAnimatorRotationY(duration: Long, vararg controls: Float): ObjectAnimator =
    objectAnimatorFloat("rotationY", duration, *controls)

fun View.objectAnimatorAlpha(duration: Long, vararg controls: Float): ObjectAnimator =
    objectAnimatorFloat("alpha", duration, *controls)