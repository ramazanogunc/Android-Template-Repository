package com.ramo.example.domain

import com.ramo.example.domain.usecase.ExampleUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Test


class ExampleUnitTest {

//  private val userRepository: UserRepository = mock(UserRepository::class.java)

  @Test
  fun `example test`() = runTest {
    val useCase = ExampleUseCase()
    try {
      useCase.invoke(Unit)
      assert(true)
    } catch (e: Exception) {
      assert(false)
    }
  }


}