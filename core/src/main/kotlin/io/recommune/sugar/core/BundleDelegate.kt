package io.recommune.sugar.core

import android.os.Bundle
import android.util.SparseArray
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


sealed class BundleDelegate<T>(
    protected val key: kotlin.String,
    protected val default: T? = null
) : ReadWriteProperty<Bundle, T> {

    class Byte(key: kotlin.String, default: kotlin.Byte? = null) : BundleDelegate<kotlin.Byte>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Byte {
            return if (default != null) thisRef.getByte(key, default) else thisRef.getByte(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Byte) {
            thisRef.putByte(key, value)
        }
    }

    class ByteArray(key: kotlin.String) : BundleDelegate<kotlin.ByteArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.ByteArray {
            return thisRef.getByteArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.ByteArray) {
            thisRef.putByteArray(key, value)
        }
    }

    class Boolean(key: kotlin.String, default: kotlin.Boolean? = null) : BundleDelegate<kotlin.Boolean>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Boolean {
            return if (default != null) thisRef.getBoolean(key, default) else thisRef.getBoolean(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Boolean) {
            thisRef.putBoolean(key, value)
        }
    }

    class BooleanArray(key: kotlin.String) : BundleDelegate<kotlin.BooleanArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.BooleanArray {
            return thisRef.getBooleanArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.BooleanArray) {
            thisRef.putBooleanArray(key, value)
        }
    }

    class Short(key: kotlin.String, default: kotlin.Short? = null) : BundleDelegate<kotlin.Short>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Short {
            return if (default != null) thisRef.getShort(key, default) else thisRef.getShort(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Short) {
            thisRef.putShort(key, value)
        }
    }

    class ShortArray(key: kotlin.String) : BundleDelegate<kotlin.ShortArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.ShortArray {
            return thisRef.getShortArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.ShortArray) {
            thisRef.putShortArray(key, value)
        }
    }

    class Int(key: kotlin.String, default: kotlin.Int? = null) : BundleDelegate<kotlin.Int>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Int {
            return if (default != null) thisRef.getInt(key, default) else thisRef.getInt(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Int) {
            thisRef.putInt(key, value)
        }
    }

    class IntArray(key: kotlin.String) : BundleDelegate<kotlin.IntArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.IntArray {
            return thisRef.getIntArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.IntArray) {
            thisRef.putIntArray(key, value)
        }
    }

    class IntArrayList(key: kotlin.String) : BundleDelegate<ArrayList<kotlin.Int>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): ArrayList<kotlin.Int> {
            return thisRef.getIntegerArrayList(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: ArrayList<kotlin.Int>) {
            thisRef.putIntegerArrayList(key, value)
        }
    }

    class Long(key: kotlin.String, default: kotlin.Long? = null) : BundleDelegate<kotlin.Long>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Long {
            return if (default != null) thisRef.getLong(key, default) else thisRef.getLong(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Long) {
            thisRef.putLong(key, value)
        }
    }

    class LongArray(key: kotlin.String) : BundleDelegate<kotlin.LongArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.LongArray {
            return thisRef.getLongArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.LongArray) {
            thisRef.putLongArray(key, value)
        }
    }

    class Float(key: kotlin.String, default: kotlin.Float? = null) : BundleDelegate<kotlin.Float>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Float {
            return if (default != null) thisRef.getFloat(key, default) else thisRef.getFloat(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Float) {
            return thisRef.putFloat(key, value)
        }
    }

    class FloatArray(key: kotlin.String) : BundleDelegate<kotlin.FloatArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.FloatArray {
            return thisRef.getFloatArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.FloatArray) {
            thisRef.putFloatArray(key, value)
        }
    }

    class Double(key: kotlin.String, default: kotlin.Double? = null) : BundleDelegate<kotlin.Double>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Double {
            return if (default != null) thisRef.getDouble(key, default) else thisRef.getDouble(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Double) {
            return thisRef.putDouble(key, value)
        }
    }

    class DoubleArray(key: kotlin.String) : BundleDelegate<kotlin.DoubleArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.DoubleArray {
            return thisRef.getDoubleArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.DoubleArray) {
            thisRef.putDoubleArray(key, value)
        }
    }

    class Char(key: kotlin.String, default: kotlin.Char? = null) : BundleDelegate<kotlin.Char>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.Char {
            return if (default != null) thisRef.getChar(key, default) else thisRef.getChar(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.Char) = thisRef.putChar(key, value)
    }

    class CharArray(key: kotlin.String) : BundleDelegate<kotlin.CharArray>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.CharArray {
            return thisRef.getCharArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.CharArray) {
            thisRef.putCharArray(key, value)
        }
    }

    class CharSequence(key: kotlin.String) : BundleDelegate<kotlin.CharSequence>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.CharSequence {
            return thisRef.getCharSequence(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.CharSequence) {
            thisRef.putCharSequence(key, value)
        }
    }

    class CharSequenceArray(key: kotlin.String) : BundleDelegate<Array<kotlin.CharSequence>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): Array<kotlin.CharSequence> {
            return thisRef.getCharSequenceArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: Array<kotlin.CharSequence>) {
            thisRef.putCharSequenceArray(key, value)
        }
    }

    class CharSequenceArrayList(key: kotlin.String) : BundleDelegate<ArrayList<kotlin.CharSequence>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): ArrayList<kotlin.CharSequence> {
            return thisRef.getCharSequenceArrayList(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: ArrayList<kotlin.CharSequence>) {
            thisRef.putCharSequenceArrayList(key, value)
        }
    }

    class String(key: kotlin.String, default: kotlin.String? = null) : BundleDelegate<kotlin.String>(key, default) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): kotlin.String {
            return if (default != null) thisRef.getString(key, default) else thisRef.getString(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: kotlin.String) {
            thisRef.putString(key, value)
        }
    }

    class StringArray(key: kotlin.String) : BundleDelegate<Array<kotlin.String>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): Array<kotlin.String> {
            return thisRef.getStringArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: Array<kotlin.String>) {
            thisRef.putStringArray(key, value)
        }
    }

    class StringArrayList(key: kotlin.String) : BundleDelegate<ArrayList<kotlin.String>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): ArrayList<kotlin.String> {
            return thisRef.getStringArrayList(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: ArrayList<kotlin.String>) {
            thisRef.putStringArrayList(key, value)
        }
    }

    class Bundle(key: kotlin.String) : BundleDelegate<android.os.Bundle>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): android.os.Bundle {
            return thisRef.getBundle(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: android.os.Bundle) {
            thisRef.putBundle(key, value)
        }
    }

    class Serializable(key: kotlin.String) : BundleDelegate<java.io.Serializable>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): java.io.Serializable {
            return thisRef.getSerializable(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: java.io.Serializable) {
            thisRef.putSerializable(key, value)
        }
    }

    class IBinder(key: kotlin.String) : BundleDelegate<android.os.IBinder>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): android.os.IBinder {
            return thisRef.getBinder(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: android.os.IBinder) {
            thisRef.putBinder(key, value)
        }
    }

    class Size(key: kotlin.String) : BundleDelegate<android.util.Size>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): android.util.Size {
            return thisRef.getSize(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: android.util.Size) {
            thisRef.putSize(key, value)
        }
    }

    class SizeF(key: kotlin.String) : BundleDelegate<android.util.SizeF>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): android.util.SizeF {
            return thisRef.getSizeF(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: android.util.SizeF) {
            thisRef.putSizeF(key, value)
        }
    }

    class Parcelable<T : android.os.Parcelable>(key: kotlin.String) : BundleDelegate<T>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): T {
            return thisRef.getParcelable(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: T) {
            thisRef.putParcelable(key, value)
        }
    }

    @Suppress("unchecked_cast")
    class ParcelableArray<T : android.os.Parcelable>(key: kotlin.String) : BundleDelegate<Array<T>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): Array<T> {
            return thisRef.getParcelableArray(key) as Array<T>
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: Array<T>) {
            thisRef.putParcelableArray(key, value)
        }
    }

    class ParcelableSparseArray<T : android.os.Parcelable>(key: kotlin.String) : BundleDelegate<SparseArray<T>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): SparseArray<T> {
            return thisRef.getSparseParcelableArray(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: SparseArray<T>) {
            thisRef.putSparseParcelableArray(key, value)
        }
    }

    class ParcelableArrayList<T : android.os.Parcelable>(key: kotlin.String) : BundleDelegate<ArrayList<T>>(key) {

        override fun getValue(thisRef: android.os.Bundle, property: KProperty<*>): ArrayList<T> {
            return thisRef.getParcelableArrayList(key)
        }

        override fun setValue(thisRef: android.os.Bundle, property: KProperty<*>, value: ArrayList<T>) {
            thisRef.putParcelableArrayList(key, value)
        }
    }
}