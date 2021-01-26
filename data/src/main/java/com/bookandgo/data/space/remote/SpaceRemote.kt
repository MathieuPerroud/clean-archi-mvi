package com.bookandgo.data.space.remote

import com.bookandgo.data.space.local.room.SpaceEntity
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse

interface SpaceRemote {
    suspend fun getAllSpaces(): GetAllSpacesResponse
}