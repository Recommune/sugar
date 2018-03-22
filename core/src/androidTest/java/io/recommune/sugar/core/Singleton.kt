package io.recommune.sugar.core

import android.os.Binder
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import java.io.Serializable


internal object Singleton {

    const val key = "key"

    const val byteValue = 1.toByte()
    const val byteDefault = 2.toByte()
    const val booleanValue = false
    const val booleanDefault = true
    const val shortValue = 1.toShort()
    const val shortDefault = 2.toShort()
    const val intValue = 1
    const val intDefault = 2
    const val longValue = 1L
    const val longDefault = 2L
    const val floatValue = 1f
    const val floatDefault = 2f
    const val doubleValue = 1.0
    const val doubleDefault = 2.0
    const val charValue = 'a'
    const val charDefault = 'b'
    const val stringValue = "value"
    const val stringDefault = "default"

    val bundleValue = Bundle()
    val parcelableValue = SomeParcelable()
    val serializableValue = SomeSerializable()
    val binderValue = Binder()
    val sizeValue = Size(0, 0)
    val sizeFValue = SizeF(0f, 0f)

    class SomeParcelable : Parcelable {
        override fun writeToParcel(dest: Parcel?, flags: Int) = Unit
        override fun describeContents(): Int = 0
    }

    class SomeSerializable : Serializable
}