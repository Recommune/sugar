package io.recommune.sugar.arch

import android.arch.lifecycle.AndroidViewModel


internal class SomeAndroidViewModelConstructor(application: SomeApplication, val id: String) : AndroidViewModel(application)