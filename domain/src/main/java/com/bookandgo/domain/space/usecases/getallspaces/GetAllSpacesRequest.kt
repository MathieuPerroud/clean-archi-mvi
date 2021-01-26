package com.bookandgo.domain.space.usecases.getallspaces

import com.bookandgo.domain.contracts.requests.ILastUpdateUseCaseRequest

class GetAllSpacesRequest(override val lastUpdate: Int? = null) : ILastUpdateUseCaseRequest