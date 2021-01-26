package com.bookandgo.domain.contracts.requests

interface ILastUpdateUseCaseRequest : IUseCaseRequest {
    val lastUpdate:Int?
}