package com.onepiece.wancompose.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onepiece.wancompose.data.MyTodoRepository
import com.onepiece.wancompose.data.di.MyLocalTodoRepository
import com.onepiece.wancompose.data.local.database.MyTodoModel
import com.onepiece.wancompose.ui.todo.MyUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyTodoViewModel @Inject constructor(private val myTodoRepository: MyTodoRepository) :
    ViewModel() {
    val uiState: StateFlow<MyUiState> =
        myTodoRepository.myModels.map(::Success).catch { MyUiState.Error(it) }.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000), MyUiState.Loading
        )


    fun addTodos(name: String) {

        // to do
        viewModelScope.launch {
            myTodoRepository.addTodo(name)
        }
    }
}


sealed interface MyUiState {
    object Loading : MyUiState
    data class Success(val data: List<String>) : MyUiState
    data class Error(val throwable: Throwable) : MyUiState
}