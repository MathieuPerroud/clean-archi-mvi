package com.bookandgo.data.sources

import com.bookandgo.data.space.local.room.SpaceEntity
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("spaces")
    fun getAllSpaces(): Call<List<SpaceEntity>>

}