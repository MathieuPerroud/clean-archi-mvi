package com.bookandgo.di

import android.content.Context
import androidx.room.Room
import com.bookandgo.data.sources.API
import com.bookandgo.data.sources.LocalDatabase
import okhttp3.OkHttpClient
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import com.bookandgo.data.BuildConfig
import com.bookandgo.data.space.SpaceRepository
import com.bookandgo.data.space.local.SpaceCache
import com.bookandgo.data.space.local.SpaceLocal
import com.bookandgo.data.space.remote.SpaceRemote
import com.bookandgo.data.space.remote.SpaceService
import com.bookandgo.domain.space.ISpaceRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DataLayerModule {
    @Singleton
    @Provides
    fun providesApi(): API =
        Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder()
                .create()))
            .baseUrl(BuildConfig.API_BOOKANDGO)
            .client(OkHttpClient.Builder().build())
            .build()
            .create(API::class.java)


    @Provides
    @Singleton
    fun providesRoom(context: Context):
            LocalDatabase = Room
        .databaseBuilder(context, LocalDatabase::class.java, "LocalDatabase")
        .build()

    @Singleton
    @Provides
    fun providesSpaceRemote(api: API): SpaceRemote = SpaceService(api)

    @Singleton
    @Provides
    fun providesSpaceLocal(
        roomDb: LocalDatabase
    ): SpaceLocal = SpaceCache(roomDb)

    @Singleton
    @Provides
    fun providesSpaceRepository(local: SpaceLocal, remote: SpaceRemote):
            ISpaceRepository = SpaceRepository(local, remote)

}