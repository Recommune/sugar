package io.recommune.sugar.core

import android.os.Bundle
import android.support.test.runner.AndroidJUnit4
import android.util.SparseArray
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(AndroidJUnit4::class)
class AndroidTestBundleDelegateArray {

    companion object {

        private val byteArray = byteArrayOf(Singleton.byteValue, Singleton.byteDefault)
        private val booleanArray = booleanArrayOf(Singleton.booleanValue, Singleton.booleanDefault)
        private val shortArray = shortArrayOf(Singleton.shortValue, Singleton.shortDefault)
        private val intArray = intArrayOf(Singleton.intValue, Singleton.intDefault)
        private val intArrayList = arrayListOf(Singleton.intValue, Singleton.intDefault)
        private val longArray = longArrayOf(Singleton.longValue, Singleton.longDefault)
        private val floatArray = floatArrayOf(Singleton.floatValue, Singleton.floatDefault)
        private val doubleArray = doubleArrayOf(Singleton.doubleValue, Singleton.doubleDefault)
        private val charArray = charArrayOf(Singleton.charValue, Singleton.charDefault)
        private val charSequenceArray = arrayOf<CharSequence>(Singleton.stringValue, Singleton.stringDefault)
        private val charSequenceArrayList = arrayListOf<CharSequence>(Singleton.stringValue, Singleton.stringDefault)
        private val stringArray = arrayOf(Singleton.stringValue, Singleton.stringDefault)
        private val stringArrayList = arrayListOf(Singleton.stringValue, Singleton.stringDefault)
        private val parcelableArray = arrayOf(Singleton.parcelableValue)
        private val parcelableArrayList = arrayListOf(Singleton.parcelableValue)
        private val parcelableSparseArray = SparseArray<Singleton.SomeParcelable>(1).also { it.put(0, Singleton.parcelableValue) }
    }

    private var Bundle.byteArray by BundleDelegate.ByteArray(Singleton.key)
    private var Bundle.booleanArray by BundleDelegate.BooleanArray(Singleton.key)
    private var Bundle.shortArray by BundleDelegate.ShortArray(Singleton.key)
    private var Bundle.intArray by BundleDelegate.IntArray(Singleton.key)
    private var Bundle.intArrayList by BundleDelegate.IntArrayList(Singleton.key)
    private var Bundle.longArray by BundleDelegate.LongArray(Singleton.key)
    private var Bundle.floatArray by BundleDelegate.FloatArray(Singleton.key)
    private var Bundle.doubleArray by BundleDelegate.DoubleArray(Singleton.key)
    private var Bundle.charArray by BundleDelegate.CharArray(Singleton.key)
    private var Bundle.charSequence by BundleDelegate.CharSequence(Singleton.key)
    private var Bundle.charSequenceArray by BundleDelegate.CharSequenceArray(Singleton.key)
    private var Bundle.charSequenceArrayList by BundleDelegate.CharSequenceArrayList(Singleton.key)
    private var Bundle.stringArray by BundleDelegate.StringArray(Singleton.key)
    private var Bundle.stringArrayList by BundleDelegate.StringArrayList(Singleton.key)
    private var Bundle.parcelableArray by BundleDelegate.ParcelableArray<Singleton.SomeParcelable>(Singleton.key)
    private var Bundle.parcelableArrayList by BundleDelegate.ParcelableArrayList<Singleton.SomeParcelable>(Singleton.key)
    private var Bundle.parcelableSparseArray by BundleDelegate.ParcelableSparseArray<Singleton.SomeParcelable>(Singleton.key)

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
        bundle.charSequence = Singleton.stringValue
        assertEquals(bundle.charSequence, Singleton.stringValue)
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