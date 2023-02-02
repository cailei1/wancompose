package com.onepiece.wancompose.ui.todo

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle

@Composable
fun MyTodoScreen(modifier: Modifier = Modifier, viewModel: MyTodoViewModel = hiltViewModel()) {

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val items by produceState<MyUiState>(
        initialValue = MyUiState.Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.uiState.collect {
                Log.e("compose item","compose item: $it" )
                value = it
            }
        }
    }

    if (items is MyUiState.Success) {
        Log.e("compose item `````","compose item: $items" )
        MyTodoScreen1(items = (items as MyUiState.Success).data, onSave = viewModel::addTodos,modifier= modifier)
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyTodoScreen1(
    items: List<String>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        var todo by remember {
            mutableStateOf("Compose")
        }


        Column(modifier = Modifier
            .padding(bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(value = todo, onValueChange = {
                todo = it
            })

            Button(modifier = Modifier.width(196.dp),onClick = {onSave(todo)}) {
                Log.e("compose button","compose button $todo")
                Text(text = todo)
            }
        }

        items.forEach{
            Text(text = it)
        }
    }
}