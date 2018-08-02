package io.recommune.sugar.android.ui.animation

import android.content.Context
import io.recommune.sugar.android.R


inline val Context.durationSimpleIcon get() = resources.getInteger(R.integer.duration_simple_icon).toLong()
inline val Context.durationAverageIcon get() = resources.getInteger(R.integer.duration_average_icon).toLong()
inline val Context.durationComplexIcon get() = resources.getInteger(R.integer.duration_complex_icon).toLong()
inline val Context.durationSimpleFadeIn get() = resources.getInteger(R.integer.duration_simple_fade_in).toLong()
inline val Context.durationSimpleFadeOut get() = resources.getInteger(R.integer.duration_simple_fade_out).toLong()
inline val Context.durationMediumExpand get() = resources.getInteger(R.integer.duration_medium_expand).toLong()
inline val Context.durationMediumCollapse get() = resources.getInteger(R.integer.duration_medium_collapse).toLong()
inline val Context.durationLargeExpand get() = resources.getInteger(R.integer.duration_large_expand).toLong()
inline val Context.durationLargeCollapse get() = resources.getInteger(R.integer.duration_large_collapse).toLong()
inline val Context.durationComplexDetailed get() = resources.getInteger(R.integer.duration_complex_detailed).toLong()
inline val Context.durationComplexShapeChange get() = resources.getInteger(R.integer.duration_complex_shape_change).toLong()