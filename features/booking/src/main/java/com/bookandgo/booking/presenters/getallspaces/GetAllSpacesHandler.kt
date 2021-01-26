package com.bookandgo.booking.presenters.getallspaces

import com.bookandgo.domain.contracts.UseCaseHandler
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesRequest
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesResponse
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesUseCase

import javax.inject.Inject

class GetAllSpacesHandler @Inject constructor(getAllSpacesUseCase: GetAllSpacesUseCase) :
    UseCaseHandler<GetAllSpacesRequest, GetAllSpacesResponse>(getAllSpacesUseCase)