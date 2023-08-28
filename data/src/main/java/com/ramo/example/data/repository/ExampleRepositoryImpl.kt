package com.ramo.example.data.repository

import com.ramo.example.domain.repository.ExampleRepository
import javax.inject.Inject

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
class ExampleRepositoryImpl @Inject constructor() : ExampleRepository {
  override suspend fun example(): List<String> {
    return listOf("Deneme")
  }

}