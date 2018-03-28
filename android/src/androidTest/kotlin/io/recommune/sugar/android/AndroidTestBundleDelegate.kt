package io.recommune.sugar.android

import android.os.Bundle
import android.support.test.runner.AndroidJUnit4
import io.recommune.sugar.android.Constant.booleanDefault
import io.recommune.sugar.android.Constant.booleanValue
import io.recommune.sugar.android.Constant.byteDefault
import io.recommune.sugar.android.Constant.byteValue
import io.recommune.sugar.android.Constant.charDefault
import io.recommune.sugar.android.Constant.charValue
import io.recommune.sugar.android.Constant.doubleDefault
import io.recommune.sugar.android.Constant.doubleValue
import io.recommune.sugar.android.Constant.floatDefault
import io.recommune.sugar.android.Constant.floatValue
import io.recommune.sugar.android.Constant.intDefault
import io.recommune.sugar.android.Constant.intValue
import io.recommune.sugar.android.Constant.key
import io.recommune.sugar.android.Constant.longDefault
import io.recommune.sugar.android.Constant.longValue
import io.recommune.sugar.android.Constant.shortDefault
import io.recommune.sugar.android.Constant.shortValue
import io.recommune.sugar.android.Constant.stringDefault
import io.recommune.sugar.android.Constant.stringValue
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