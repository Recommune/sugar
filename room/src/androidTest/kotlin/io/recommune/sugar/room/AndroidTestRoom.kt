package io.recommune.sugar.room

import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.support.test.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class AndroidTestRoom {

    private abstract class RoomAbstractDatabase {

        abstract val room: RoomDatabase
    }

    private class SomeRoomConcrete(override val room: RoomDatabase) : RoomAbstractDatabase()

    private sealed class RoomBuilder(val context: Context) {

        class Memory(context: Context) : RoomBuilder(context)

        class Disk(context: Context, val databaseName: String) : RoomBuilder(context)
    }

    private fun RoomBuilder.build(): RoomAbstractDatabase {
        val room = when (this) {
            is RoomBuilder.Memory -> context.roomInMemory<SomeRoomDatabase>()
            is RoomBuilder.Disk -> context.roomOnDisk<SomeRoomDatabase>(databaseName)
        }.build()
        return SomeRoomConcrete(room)
    }

    private lateinit var context: Context

    @Before
    fun before() {
        context = InstrumentationRegistry.getContext()
    }

    @Test
    fun disk() {
        RoomBuilder.Disk(context, "database").build()
    }

    @Test
    fun memory() {
        RoomBuilder.Memory(context).build()
    }
}