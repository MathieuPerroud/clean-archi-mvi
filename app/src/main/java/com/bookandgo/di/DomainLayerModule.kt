package com.bookandgo.di

import com.bookandgo.domain.space.ISpaceRepository
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class DomainLayerModule {

    @Provides
    fun providesGetAllSpacesUseCase(spaceRepository: ISpaceRepository): GetAllSpacesUseCase
            = GetAllSpacesUseCase(spaceRepository)

}