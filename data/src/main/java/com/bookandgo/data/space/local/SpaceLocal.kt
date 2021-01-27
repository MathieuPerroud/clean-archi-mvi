package com.bookandgo.data.space.local


import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse

interface SpaceLocal {
    fun getAllSpaces() : GetAllSpacesResponse
}