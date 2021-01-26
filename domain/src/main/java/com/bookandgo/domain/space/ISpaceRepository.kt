package com.bookandgo.domain.space

import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse

interface ISpaceRepository {
    suspend fun getAllSpaces(): GetAllSpacesResponse
}