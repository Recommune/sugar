package io.recommune.sugar.core.jvm

import io.recommune.sugar.core.Either
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.concurrent.ThreadLocalRandom
import kotlin.test.assertEquals


@RunWith(JUnit4::class)
class TestEither {

    @Test
    fun either() {
        val either = eitherRandom()
        val left = { left: Either.Left<Int, String> -> assertEquals(0, left.data) }
        val right = { right: Either.Right<Int, String> -> assertEquals("3", right.data) }

        either.either(left, right)
        either.isLeft(left).isRight(right)
        when (either) {
            is Either.Left -> assertEquals(0, either.data)
            is Either.Right -> assertEquals("3", either.data)
        }
    }

    companion object {

        private fun eitherRandom(): Either<Int, String> {
            val boolean = ThreadLocalRandom.current().nextBoolean()
            return if (boolean) {
                Either.Left(0)
            } else {
                Either.Right("3")
            }
        }
    }
}