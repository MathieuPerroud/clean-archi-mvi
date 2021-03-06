package com.bookandgo.data.space

import com.bookandgo.data.space.local.SpaceLocal
import com.bookandgo.data.space.remote.SpaceRemote
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.space.ISpaceRepository
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse

class SpaceRepository(private val local : SpaceLocal, private val remote : SpaceRemote )
    : ISpaceRepository {
    override suspend fun getAllSpaces(): GetAllSpacesResponse {
        return remote.getAllSpaces().let {
            if (it.result is IResultFailure<*>){
                local.getAllSpaces()
            } else {it}
        }
        //TODO : Look into Database then call through API and integrate in localdb
    }
}