package com.ramo.example.domain.model

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
data class LoginParams(
  var countryCode: String = "",
  var gsm: String = "",
  var password: String = "",
)