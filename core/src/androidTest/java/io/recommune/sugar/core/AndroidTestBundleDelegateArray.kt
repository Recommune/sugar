package io.recommune.sugar.core

import android.os.Bundle
import android.support.test.runner.AndroidJUnit4
import io.recommune.sugar.core.Constant.booleanArray
import io.recommune.sugar.core.Constant.byteArray
import io.recommune.sugar.core.Constant.charArray
import io.recommune.sugar.core.Constant.charSequenceArray
import io.recommune.sugar.core.Constant.charSequenceArrayList
import io.recommune.sugar.core.Constant.doubleArray
import io.recommune.sugar.core.Constant.floatArray
import io.recommune.sugar.core.Constant.intArray
import io.recommune.sugar.core.Constant.intArrayList
import io.recommune.sugar.core.Constant.longArray
import io.recommune.sugar.core.Constant.parcelableArray
import io.recommune.sugar.core.Constant.parcelableArrayList
import io.recommune.sugar.core.Constant.parcelableSparseArray
import io.recommune.sugar.core.Constant.shortArray
import io.recommune.sugar.core.Constant.stringArray
import io.recommune.sugar.core.Constant.stringArrayList
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(AndroidJUnit4::class)
class AndroidTestBundleDelegateArray {

    private var Bundle.byteArray by BundleDelegate.ByteArray(Constant.key)
    private var Bundle.booleanArray by BundleDelegate.BooleanArray(Constant.key)
    private var Bundle.shortArray by BundleDelegate.ShortArray(Constant.key)
    private var Bundle.intArray by BundleDelegate.IntArray(Constant.key)
    private var Bundle.intArrayList by BundleDelegate.IntArrayList(Constant.key)
    private var Bundle.longArray by BundleDelegate.LongArray(Constant.key)
    private var Bundle.floatArray by BundleDelegate.FloatArray(Constant.key)
    private var Bundle.doubleArray by BundleDelegate.DoubleArray(Constant.key)
    private var Bundle.charArray by BundleDelegate.CharArray(Constant.key)
    private var Bundle.charSequence by BundleDelegate.CharSequence(Constant.key)
    private var Bundle.charSequenceArray by BundleDelegate.CharSequenceArray(Constant.key)
    private var Bundle.charSequenceArrayList by BundleDelegate.CharSequenceArrayList(Constant.key)
    private var Bundle.stringArray by BundleDelegate.StringArray(Constant.key)
    private var Bundle.stringArrayList by BundleDelegate.StringArrayList(Constant.key)
    private var Bundle.parcelableArray by BundleDelegate.ParcelableArray<Constant.SomeParcelable>(Constant.key)
    private var Bundle.parcelableArrayList by BundleDelegate.ParcelableArrayList<Constant.SomeParcelable>(Constant.key)
    private var Bundle.parcelableSparseArray by BundleDelegate.ParcelableSparseArray<Constant.SomeParcelable>(Constant.key)

    private lateinit var bundle: Bundle

    @Before
    fun before() {
        bundle = Bundle()
    }


    @Test
    fun byteArray() {
        bundle.byteArray = byteArray
        assertEquals(bundle.byteArray, byteArray)
    }

    @Test
    fun booleanArray() {
        bundle.booleanArray = booleanArray
        assertEquals(bundle.booleanArray, booleanArray)
    }

    @Test
    fun shortArray() {
        bundle.shortArray = shortArray
        assertEquals(bundle.shortArray, shortArray)
    }

    @Test
    fun intArray() {
        bundle.intArray = intArray
        assertEquals(bundle.intArray, intArray)
    }

    @Test
    fun intArrayList() {
        bundle.intArrayList = intArrayList
        assertEquals(bundle.intArrayList, intArrayList)
    }

    @Test
    fun longArray() {
        bundle.longArray = longArray
        assertEquals(bundle.longArray, longArray)
    }

    @Test
    fun floatArray() {
        bundle.floatArray = floatArray
        assertEquals(bundle.floatArray, floatArray)
    }

    @Test
    fun doubleArray() {
        bundle.doubleArray = doubleArray
        assertEquals(bundle.doubleArray, doubleArray)
    }

    @Test
    fun charArray() {
        bundle.charArray = charArray
        assertEquals(bundle.charArray, charArray)
    }

    @Test
    fun charSequence() {
        bundle.charSequence = Constant.stringValue
        assertEquals(bundle.charSequence, Constant.stringValue)
    }

    @Test
    fun charSequenceArray() {
        bundle.charSequenceArray = charSequenceArray
        assertEquals(bundle.charSequenceArray, charSequenceArray)
    }

    @Test
    fun charSequenceArrayList() {
        bundle.charSequenceArrayList = charSequenceArrayList
        assertEquals(bundle.charSequenceArrayList, charSequenceArrayList)
    }

    @Test
    fun stringArray() {
        bundle.stringArray = stringArray
        assertEquals(bundle.stringArray, stringArray)
    }

    @Test
    fun stringArrayList() {
        bundle.stringArrayList = stringArrayList
        assertEquals(bundle.stringArrayList, stringArrayList)
    }

    @Test
    fun parcelableArray() {
        bundle.parcelableArray = parcelableArray
        assertEquals(bundle.parcelableArray, parcelableArray)
    }

    @Test
    fun parcelableArrayList() {
        bundle.parcelableArrayList = parcelableArrayList
        assertEquals(bundle.parcelableArrayList, parcelableArrayList)
    }

    @Test
    fun parcelableSparseArray() {
        bundle.parcelableSparseArray = parcelableSparseArray
        assertEquals(bundle.parcelableSparseArray, parcelableSparseArray)
    }
}