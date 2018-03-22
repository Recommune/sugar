package io.recommune.sugar.core

import android.os.Bundle
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class AndroidTestBundleDelegateObject {

    private var Bundle.bundle by BundleDelegate.Bundle(Singleton.key)
    private var Bundle.parcelable by BundleDelegate.Parcelable<Singleton.SomeParcelable>(Singleton.key)
    private var Bundle.serializable by BundleDelegate.Serializable(Singleton.key)
    private var Bundle.binder by BundleDelegate.IBinder(Singleton.key)
    private var Bundle.size by BundleDelegate.Size(Singleton.key)
    private var Bundle.sizeF by BundleDelegate.SizeF(Singleton.key)

    private lateinit var bundle: Bundle

    @Before
    fun before() {
        bundle = Bundle()
    }

    @Test
    fun bundle() {
        bundle.bundle = Singleton.bundleValue
        assertEquals(bundle.bundle, Singleton.bundleValue)
    }

    @Test
    fun binder() {
        bundle.binder = Singleton.binderValue
        assertEquals(bundle.binder, Singleton.binderValue)
    }

    @Test
    fun serializable() {
        bundle.serializable = Singleton.serializableValue
        assertEquals(bundle.serializable, Singleton.serializableValue)
    }

    @Test
    fun size() {
        bundle.size = Singleton.sizeValue
        assertEquals(bundle.size, Singleton.sizeValue)
    }

    @Test
    fun sizeF() {
        bundle.sizeF = Singleton.sizeFValue
        assertEquals(bundle.sizeF, Singleton.sizeFValue)
    }

    @Test
    fun parcelable() {
        bundle.parcelable = Singleton.parcelableValue
        assertEquals(bundle.parcelable, Singleton.parcelableValue)
    }
}