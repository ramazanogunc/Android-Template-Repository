package com.ramo.example.domain.di

import com.ramo.example.domain.usecase.ExampleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

  @Provides
  fun provideCampaignListUseCase(): ExampleUseCase {
    return ExampleUseCase()
  }

}