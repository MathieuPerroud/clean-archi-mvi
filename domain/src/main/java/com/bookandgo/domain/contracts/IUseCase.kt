package com.bookandgo.domain.contracts

import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.contracts.requests.IUseCaseRequest

interface IUseCase<Request: IUseCaseRequest,Response: UseCaseResponse<*>> {
    suspend fun execute(request: Request, presenter: IUseCasePresenter<Response>)
}