package io.recommune.sugar.core


sealed class Either<L, R> {

    class Left<L, R>(val data: L) : Either<L, R>()

    class Right<L, R>(val data: R) : Either<L, R>()

    inline fun either(left: (Either.Left<L, R>) -> Unit, right: (Either.Right<L, R>) -> Unit) {
        when (this) {
            is Left -> left(this)
            is Right -> right(this)
        }
    }
}