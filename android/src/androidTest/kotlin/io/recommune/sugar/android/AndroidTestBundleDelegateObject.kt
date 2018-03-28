package io.recommune.sugar.android

import android.os.Bundle
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


internal class AndroidTestBundleDelegateObject {

    private var Bundle.bundle by BundleDelegate.Bundle(Constant.key)
    private var Bundle.parcelable by BundleDelegate.Parcelable<Constant.SomeParcelable>(Constant.key)
    private var Bundle.serializable by BundleDelegate.Serializable(Constant.key)
    private var Bundle.binder by BundleDelegate.IBinder(Constant.key)
    private var Bundle.size by BundleDelegate.Size(Constant.key)
    private var Bundle.sizeF by BundleDelegate.SizeF(Constant.key)

    private lateinit var bundle: Bundle

    @Before
    fun before() {
        bundle = Bundle()
    }

    @Test
    fun bundle() {
        bundle.bundle = Constant.bundleValue
        assertEquals(bundle.bundle, Constant.bundleValue)
    }

    @Test
    fun binder() {
        bundle.binder = Constant.binderValue
        assertEquals(bundle.binder, Constant.binderValue)
    }

    @Test
    fun serializable() {
        bundle.serializable = Constant.serializableValue
        assertEquals(bundle.serializable, Constant.serializableValue)
    }

    @Test
    fun size() {
        bundle.size = Constant.sizeValue
        assertEquals(bundle.size, Constant.sizeValue)
    }

    @Test
    fun sizeF() {
        bundle.sizeF = Constant.sizeFValue
        assertEquals(bundle.sizeF, Constant.sizeFValue)
    }

    @Test
    fun parcelable() {
        bundle.parcelable = Constant.parcelableValue
        assertEquals(bundle.parcelable, Constant.parcelableValue)
    }
}