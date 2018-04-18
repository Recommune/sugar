package io.recommune.sugar.core


sealed class Either<L, R> {

    class Left<L, R>(val data: L) : Either<L, R>()

    class Right<L, R>(val data: R) : Either<L, R>()

    class LeftConsumed<L, R>(private val either: Either<L, R>) {

        fun isRight(block: (Either.Right<L, R>) -> Unit) {
            when (either) {
                is Right -> block(either)
            }
        }
    }

    class RightConsumed<L, R>(private val either: Either<L, R>) {

        fun isLeft(block: (Either.Left<L, R>) -> Unit) {
            when (either) {
                is Left -> block(either)
            }
        }
    }

    inline fun either(left: (Either.Left<L, R>) -> Unit, right: (Either.Right<L, R>) -> Unit) {
        when (this) {
            is Left -> left(this)
            is Right -> right(this)
        }
    }

    inline fun isLeft(block: (Either.Left<L, R>) -> Unit): LeftConsumed<L, R> {
        when (this) {
            is Left -> block(this)
        }
        return LeftConsumed(this)
    }

    inline fun isRight(block: (Either.Right<L, R>) -> Unit): RightConsumed<L, R> {
        when (this) {
            is Right -> block(this)
        }
        return RightConsumed(this)
    }
}