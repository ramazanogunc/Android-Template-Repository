package com.ramo.example.data.di

import com.ramo.example.data.repository.ExampleRepositoryImpl
import com.ramo.example.domain.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

  @Provides
  fun provideCampaignRepository(): ExampleRepository {
    return ExampleRepositoryImpl()
  }

}