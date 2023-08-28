package com.ramo.example.domain.repository

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
interface ExampleRepository {
  suspend fun example(): List<String>
}