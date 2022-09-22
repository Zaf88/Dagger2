package com.example

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

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
    }}