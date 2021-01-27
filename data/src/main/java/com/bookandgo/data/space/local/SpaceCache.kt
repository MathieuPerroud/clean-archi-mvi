package com.bookandgo.data.space.local

import com.bookandgo.data.sources.LocalDatabase
import com.bookandgo.data.space.local.room.SpaceEntity
import com.bookandgo.domain.Either
import com.bookandgo.domain.contracts.responses.results.http.HttpResultFailure
import com.bookandgo.domain.contracts.responses.results.sqlite.SQLiteResultSuccess
import com.bookandgo.domain.space.Space
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse
import java.util.*

class SpaceCache(db: LocalDatabase) : SpaceLocal {
    override fun getAllSpaces(): GetAllSpacesResponse {
        return GetAllSpacesResponse(
            Either.Success(
                SQLiteResultSuccess(
                    listOf(
                        Space("Espace Napoléon", emptyList()),
                        Space("Salon Rothschild", emptyList())
                    ),
                    Date()
                )
            )
        )
    }


}