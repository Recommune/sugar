package io.recommune.sugar.core

import android.os.Bundle
import android.support.test.runner.AndroidJUnit4
import io.recommune.sugar.core.Singleton.booleanDefault
import io.recommune.sugar.core.Singleton.booleanValue
import io.recommune.sugar.core.Singleton.byteDefault
import io.recommune.sugar.core.Singleton.byteValue
import io.recommune.sugar.core.Singleton.charDefault
import io.recommune.sugar.core.Singleton.charValue
import io.recommune.sugar.core.Singleton.doubleDefault
import io.recommune.sugar.core.Singleton.doubleValue
import io.recommune.sugar.core.Singleton.floatDefault
import io.recommune.sugar.core.Singleton.floatValue
import io.recommune.sugar.core.Singleton.intDefault
import io.recommune.sugar.core.Singleton.intValue
import io.recommune.sugar.core.Singleton.key
import io.recommune.sugar.core.Singleton.longDefault
import io.recommune.sugar.core.Singleton.longValue
import io.recommune.sugar.core.Singleton.shortDefault
import io.recommune.sugar.core.Singleton.shortValue
import io.recommune.sugar.core.Singleton.stringDefault
import io.recommune.sugar.core.Singleton.stringValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class AndroidTestBundleDelegate {

    private var Bundle.byte by BundleDelegate.Byte(key, byteDefault)
    private var Bundle.boolean by BundleDelegate.Boolean(key, booleanDefault)
    private var Bundle.short by BundleDelegate.Short(key, shortDefault)
    private var Bundle.int by BundleDelegate.Int(key, intDefault)
    private var Bundle.long by BundleDelegate.Long(key, longDefault)
    private var Bundle.float by BundleDelegate.Float(key, floatDefault)
    private var Bundle.double by BundleDelegate.Double(key, doubleDefault)
    private var Bundle.char by BundleDelegate.Char(key, charDefault)
    private var Bundle.string by BundleDelegate.String(key, stringDefault)

    private lateinit var bundle: Bundle

    @Before
    fun before() {
        bundle = Bundle()
    }

    @Test
    fun byte() {
        assertEquals(bundle.byte, byteDefault)
        bundle.byte = byteValue
        assertEquals(bundle.byte, byteValue)
    }

    @Test
    fun short() {
        assertEquals(bundle.short, shortDefault)
        bundle.short = shortValue
        assertEquals(bundle.short, shortValue)
    }

    @Test
    fun int() {
        assertEquals(bundle.int, intDefault)
        bundle.int = intValue
        assertEquals(bundle.int, intValue)
    }

    @Test
    fun boolean() {
        assertEquals(bundle.boolean, booleanDefault)
        bundle.boolean = booleanValue
        assertEquals(bundle.boolean, booleanValue)
    }

    @Test
    fun long() {
        assertEquals(bundle.long, longDefault)
        bundle.long = longValue
        assertEquals(bundle.long, longValue)
    }

    @Test
    fun float() {
        assertEquals(bundle.float, floatDefault)
        bundle.float = floatValue
        assertEquals(bundle.float, floatValue)
    }

    @Test
    fun double() {
        assertEquals(bundle.double, doubleDefault)
        bundle.double = doubleValue
        assertEquals(bundle.double, doubleValue)
    }

    @Test
    fun char() {
        assertEquals(bundle.char, charDefault)
        bundle.char = charValue
        assertEquals(bundle.char, charValue)
    }

    @Test
    fun string() {
        assertEquals(bundle.string, stringDefault)
        bundle.string = stringValue
        assertEquals(bundle.string, stringValue)
    }
}