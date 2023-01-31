package com.onepiece.wancompose.data

import com.onepiece.wancompose.data.local.database.MyTodoDao
import com.onepiece.wancompose.data.local.database.MyTodoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface MyTodoRepository {
    suspend fun addTodo(todo: String)

    val myModels: Flow<List<String>>
}


class LocalRepository @Inject constructor(private val myTodoDao: MyTodoDao) : MyTodoRepository {
    override suspend fun addTodo(todo: String) {
        myTodoDao.insertMyTodo(MyTodoModel(todo))
    }

    override val myModels: Flow<List<String>> =
        myTodoDao.getMyTodos().map { items -> items.map { it.name } }

}
