package com.bookandgo.domain.contracts

import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.contracts.presenters.holders.UseCasePresenterHolder
import com.bookandgo.domain.contracts.requests.IUseCaseRequest

@Suppress("UNCHECKED_CAST")
abstract class UseCaseHandler<Request: IUseCaseRequest, Response: UseCaseResponse<*>>
    (private val useCase: IUseCase<Request,Response>){
    open suspend fun handle(request: Request, presenter: IUseCasePresenter<Response>): UseCasePresenterHolder  {
            useCase.execute(request,presenter)
            return presenter.holder
    }
}