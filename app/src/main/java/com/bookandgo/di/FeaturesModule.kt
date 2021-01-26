package com.bookandgo.di

import android.app.Application
import android.content.Context
import com.bookandgo.booking.presenters.getallspaces.GetAllSpacesHandler
import dagger.Module

import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class FeaturesModule {/*
    @Provides
    @Singleton
    fun providesGetAllSpacesHandler(appInstance: Application): GetAllSpacesHandler = Get*/


}