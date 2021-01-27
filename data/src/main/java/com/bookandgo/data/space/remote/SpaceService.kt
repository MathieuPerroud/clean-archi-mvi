package com.bookandgo.data.space.remote

import com.bookandgo.data.CallService
import com.bookandgo.data.sources.API
import com.bookandgo.data.space.local.room.SpaceEntity
import com.bookandgo.domain.Either
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException
import com.bookandgo.domain.contracts.responses.exceptions.RemoteAccessException
import com.bookandgo.domain.contracts.responses.exceptions.RemoteTimeoutException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.contracts.responses.results.IResultSuccess
import com.bookandgo.domain.contracts.responses.results.http.HttpResultFailure
import com.bookandgo.domain.contracts.responses.results.http.HttpResultSuccess
import com.bookandgo.domain.space.Space
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse
import org.json.JSONException
import java.io.IOException
import java.util.*

class SpaceService(private val api: API) : CallService(), SpaceRemote {
    override suspend fun getAllSpaces(): GetAllSpacesResponse {
        fun treatApiResponse(): Either<HttpResultSuccess<List<Space>?>, HttpResultFailure<RemoteAccessException>> {
            var message = ""
            var code = -1
            try {
                with(api.getAllSpaces().execute()) {
                    message = this.message()
                    code = code()
                    if (isSuccessful) {
                        return Either.Success(
                            HttpResultSuccess(code(), Date(),
                                body()?.map { entity -> fromEntityToModel(entity) })
                        )
                    } else {
                        message = this.raw().message()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return Either.Failure(
                    HttpResultFailure(
                        code,
                        Date(),
                        RemoteAccessException(e.message)
                    )
                )
            }
            message = if (message == "") "Timeout" else message
            return Either.Failure(
                HttpResultFailure(
                    httpCode = code,
                    exception = RemoteTimeoutException("Timeout : Erreur $code")
                )
            )
        }
        return GetAllSpacesResponse(treatApiResponse())
    }

    //Exemple d'instanciation via un paradigme fonctionnel
    private fun fromEntityToModel(spaceEntity: SpaceEntity) = Space(spaceEntity.name, emptyList())

}