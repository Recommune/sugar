package io.recommune.sugar.android.extension

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager


val Fragment.fragmentActivity get() = requireActivity()
val Fragment.appCompatActivity get() = requireActivity() as AppCompatActivity
val Fragment.supportActionBar get() = appCompatActivity.supportActionBar!!
val Fragment.getContext get() = requireContext()
val Fragment.inputMethodManager get() = appCompatActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager