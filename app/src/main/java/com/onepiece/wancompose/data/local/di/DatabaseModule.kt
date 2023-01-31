package com.onepiece.wancompose.data.local.di

import android.content.Context
import androidx.room.Room
import com.onepiece.wancompose.data.local.database.AppDatabase
import com.onepiece.wancompose.data.local.database.MyTodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Factory 类 生产类的工厂 方便其他地方注入使用
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    // 提供数据库访问的 dao 对象
    @Provides
    fun providerMyTodoDao(appDatabase: AppDatabase):MyTodoDao{
        return appDatabase.myTodoDao()
    }

    @Provides
    @Singleton
    fun providerAppDatabase(@ApplicationContext appContext:Context):AppDatabase{
        return Room.databaseBuilder(appContext,AppDatabase::class.java,"myTodo").build()
    }
}