package com.bookandgo.domain.space.usecases.getallspaces

import com.bookandgo.domain.contracts.IUseCase
import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.space.ISpaceRepository

class GetAllSpacesUseCase(private val spaceRepository: ISpaceRepository): IUseCase<GetAllSpacesRequest,GetAllSpacesResponse> {
    override suspend fun execute(request: GetAllSpacesRequest, presenter: IUseCasePresenter<GetAllSpacesResponse>) {

        presenter.present(spaceRepository.getAllSpaces())
        //TODO : generate presenter data
    }
}