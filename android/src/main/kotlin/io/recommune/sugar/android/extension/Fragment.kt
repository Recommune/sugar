package io.recommune.sugar.android.extension

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager


val Fragment.appcompatActivity get() = requireActivity() as AppCompatActivity
val Fragment.supportActionBar get() = appcompatActivity.supportActionBar!!
val Fragment.getContext get() = requireContext()
val Fragment.inputMethodManager get() = appcompatActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager