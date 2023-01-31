package com.onepiece.wancompose

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onepiece.wancompose.ui.todo.MyTodoScreen


@Composable
fun MyNavigation() {
    // 设置路由控制器
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MyTodoScreen(modifier = Modifier.padding(16.dp)) }
    }
}