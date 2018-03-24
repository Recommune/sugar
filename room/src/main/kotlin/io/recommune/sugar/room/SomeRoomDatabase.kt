package io.recommune.sugar.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [SomeEntity::class], version = 1)
internal abstract class SomeRoomDatabase : RoomDatabase()