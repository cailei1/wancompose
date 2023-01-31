package com.onepiece.wancompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * 使用hilt 必须用到 hiltAndroidApp 注解 application
 */

@HiltAndroidApp
class MyApplication : Application()