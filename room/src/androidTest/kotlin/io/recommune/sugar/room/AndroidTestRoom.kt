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

    private class SomeRoomConcrete(room: RoomDatabase) : RoomAbstractDatabase() {

        override val database: RoomDatabase = room
    }

    private fun RoomAbstractDatabase.Builder.build(): RoomAbstractDatabase {
        val room = when (this) {
            is RoomAbstractDatabase.Builder.Memory -> context.roomInMemory<SomeRoomDatabase>()
            is RoomAbstractDatabase.Builder.Disk -> context.roomOnDisk<SomeRoomDatabase>(databaseName)
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
        RoomAbstractDatabase.Builder.Disk(context, "database").build()
    }

    @Test
    fun memory() {
        RoomAbstractDatabase.Builder.Memory(context).build()
    }
}