package com.ramo.example.domain.usecase

import com.ramo.example.domain.core.UseCase
import javax.inject.Inject

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
class ExampleUseCase @Inject constructor(
) : UseCase<Unit, List<String>>() {
  override suspend fun invoke(param: Unit): List<String> {
    return listOf("Example");
  }
}
