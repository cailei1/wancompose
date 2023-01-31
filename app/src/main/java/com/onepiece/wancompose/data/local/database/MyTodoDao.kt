package com.onepiece.wancompose.data.local.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity
data class MyTodoModel(val name: String) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}


@Dao
interface MyTodoDao{

    @Query("SELECT * FROM mytodomodel ORDER BY uid DESC LIMIT 10")
    fun getMyTodos():Flow<List<MyTodoModel>>

    @Insert
    suspend fun insertMyTodo(item:MyTodoModel)

}