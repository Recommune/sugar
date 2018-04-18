package io.recommune.sugar.core.jvm

import io.recommune.sugar.core.NonEmptyList
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Test
import kotlin.test.assertEquals


@RunWith(JUnit4::class)
class TestNonEmptyList {

    @Test
    fun nonEmptyListIsNull() {
        val list = listOf<Int>()
        val nonEmptyList = NonEmptyList.from(list)

        assertEquals(null, nonEmptyList)
    }

    @Test
    fun nonEmptyListIsNotNull() {
        val list = listOf(3)
        val nonEmptyList = NonEmptyList.from(list)

        assertEquals(list, nonEmptyList!!)
    }
}