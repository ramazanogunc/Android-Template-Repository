package com.ramo.myapplication.data


abstract class Repository {

    protected suspend fun <T> exec(func: suspend () -> T): T {
        return try {
            func.invoke()
        } catch (exception: Exception) {
            // TODO: Project custom exception logic
            throw exception
        }
    }

}
