package io.recommune.sugar.core


abstract class NonEmptyList<out E> : List<E> {

    protected abstract val list: List<E>

    private class Implementation<E>(override val list: List<E>) : NonEmptyList<E>() {

        override val size: Int = list.size

        override fun contains(element: E): Boolean = list.contains(element)

        override fun containsAll(elements: Collection<E>): Boolean = list.containsAll(elements)

        override fun get(index: Int): E = list[index]

        override fun indexOf(element: E): Int = list.indexOf(element)

        override fun isEmpty(): Boolean = list.isEmpty()

        override fun iterator(): Iterator<E> = list.iterator()

        override fun lastIndexOf(element: E): Int = list.lastIndexOf(element)

        override fun listIterator(): ListIterator<E> = list.listIterator()

        override fun listIterator(index: Int): ListIterator<E> = list.listIterator(index)

        override fun subList(fromIndex: Int, toIndex: Int): List<E> = list.subList(fromIndex, toIndex)
    }

    companion object {

        fun <E> from(list: List<E>): NonEmptyList<E>? {
            return if (list.isEmpty()) {
                null
            } else {
                Implementation(list)
            }
        }
    }
}
