package com.bookandgo.domain.space.usecases.getonespace

import com.bookandgo.domain.contracts.IUseCase
import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.space.ISpaceRepository

class GetOneSpaceUseCase(private val slotRepository: ISpaceRepository) : IUseCase<GetOneSpaceRequest, GetOneSpaceResponse> {
    override suspend fun execute(
        request: GetOneSpaceRequest,
        presenter: IUseCasePresenter<GetOneSpaceResponse>
    ) {
        /*val response = slotRepository.getOneSlot(request)
        presenter.present(response)*/
    }
/*    override suspend fun execute(
        request: GetOneSlotRequest,
        presenter: IUseCasePresenter<GetOneSlotResponse<Slot>>
    ) {
        presenter.present(GetOneSlotResponse(State(StatusType.Success),Slot("Johnson")))
    }*/

}