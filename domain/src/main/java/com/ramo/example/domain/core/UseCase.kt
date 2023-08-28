package com.ramo.example.domain.core

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
abstract class UseCase<PARAMS, RESPONSE> {
  abstract suspend operator fun invoke(param: PARAMS): RESPONSE
}