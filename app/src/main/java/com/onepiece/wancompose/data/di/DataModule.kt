package com.onepiece.wancompose.data.di

import com.onepiece.wancompose.data.LocalRepository
import com.onepiece.wancompose.data.MyTodoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

     @Singleton
     @Binds
     fun bindsMyRepository(myTodoRepository: LocalRepository):MyTodoRepository


}


class MyLocalTodoRepository @Inject constructor(): MyTodoRepository{
    override suspend fun addTodo(todo: String) {

    }

    override val myModels: Flow<List<String>>
        get() = flowOf(todos)

}


val todos = listOf("one","two","three")