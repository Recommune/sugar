package io.recommune.sugar.android

import android.view.View


fun Boolean.toVisibility() = if (this) View.VISIBLE else View.GONE