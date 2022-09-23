/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.example.dagger2.MyTestApplication

//import com.example.dagger2.MyTestApplication

/**
 * A custom [AndroidJUnitRunner] used to replace the application used in tests with a
 * [MyTestApplication].
 */

//Использование пользовательского приложения в инструментальных тестах
//
// До этого в наших сквозных тестах использовалось пользовательское приложение под названием MyTestApplication.
// Чтобы использовать другое приложение, нам пришлось создать новый TestRunner.
// Код для этого находится в файле app/src/androidTest/java/com/example/android/dagger/MyCustomTestRunner.kt
// . Код уже есть в проекте, добавлять его не нужно
//Проекту известно, что этот TestRunner необходимо использовать при выполнении инструментальных тестов,
// поскольку он указан в файле app/build.gradle.

class MyCustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, MyTestApplication::class.java.name, context)
    }
}
