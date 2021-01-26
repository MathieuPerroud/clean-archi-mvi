package com.bookandgo.booking.presenters.getallspaces

import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.contracts.presenters.holders.FailureHolder
import com.bookandgo.domain.contracts.presenters.holders.SuccessHolder
import com.bookandgo.domain.contracts.presenters.holders.UseCasePresenterHolder
import com.bookandgo.domain.space.Space
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse

class GetAllSpacesPresenter : IUseCasePresenter<GetAllSpacesResponse> {
    override lateinit var holder: UseCasePresenterHolder

    override suspend fun present(response: GetAllSpacesResponse) {
        response.result.either(
            onSuccess = {
                holder = it.data?.let { spaces ->
                        SuccessfulHolder(spaces)
                }?: NoDataHolder()
            },
            onFailure = {  holder = RandomFailureHolder(it.exception.message)}
        )
    }

    class SuccessfulHolder(val spaces: List<Space>): SuccessHolder()
    class NoDataHolder: FailureHolder("Ain't no data")
    class RandomFailureHolder(override val message: String?): FailureHolder(message)
}
