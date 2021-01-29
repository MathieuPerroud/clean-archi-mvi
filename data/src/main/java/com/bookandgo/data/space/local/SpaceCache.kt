package com.bookandgo.data.space.local

import com.bookandgo.data.sources.LocalDatabase
import com.bookandgo.data.space.local.room.SpaceEntity
import com.bookandgo.domain.Either
import com.bookandgo.domain.booking.Booking
import com.bookandgo.domain.contracts.responses.results.http.HttpResultFailure
import com.bookandgo.domain.contracts.responses.results.sqlite.SQLiteResultSuccess
import com.bookandgo.domain.slot.Slot
import com.bookandgo.domain.space.Space
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse
import java.util.*

class SpaceCache(db: LocalDatabase) : SpaceLocal {
    override fun getAllSpaces(): GetAllSpacesResponse {
        return GetAllSpacesResponse(
            Either.Success(
                SQLiteResultSuccess(
                    listOf(
                        Space("Espace Napoléon", listOf(
                            Booking("Michelle Pfeiffer", Slot(12,30), Slot(14,0)),
                            Booking("Mathieu Perroud", Slot(15,0), Slot(17,0)),
                        )),
                        Space("Salon Rothschild", listOf(
                            Booking("Lucas Grebot", Slot(9,0), Slot(12,30)),
                            Booking("Lucien Lachataigne", Slot(13,30), Slot(14,0)),
                        ))
                    ),
                    Date()
                )
            )
        )
    }


}