package io.recommune.sugar.core

import android.os.Bundle
import android.support.test.runner.AndroidJUnit4
import io.recommune.sugar.core.Constant.booleanDefault
import io.recommune.sugar.core.Constant.booleanValue
import io.recommune.sugar.core.Constant.byteDefault
import io.recommune.sugar.core.Constant.byteValue
import io.recommune.sugar.core.Constant.charDefault
import io.recommune.sugar.core.Constant.charValue
import io.recommune.sugar.core.Constant.doubleDefault
import io.recommune.sugar.core.Constant.doubleValue
import io.recommune.sugar.core.Constant.floatDefault
import io.recommune.sugar.core.Constant.floatValue
import io.recommune.sugar.core.Constant.intDefault
import io.recommune.sugar.core.Constant.intValue
import io.recommune.sugar.core.Constant.key
import io.recommune.sugar.core.Constant.longDefault
import io.recommune.sugar.core.Constant.longValue
import io.recommune.sugar.core.Constant.shortDefault
import io.recommune.sugar.core.Constant.shortValue
import io.recommune.sugar.core.Constant.stringDefault
import io.recommune.sugar.core.Constant.stringValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
internal class AndroidTestBundleDelegate {

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