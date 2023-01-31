package com.onepiece.wancompose.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MyTodoModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myTodoDao(): MyTodoDao
}