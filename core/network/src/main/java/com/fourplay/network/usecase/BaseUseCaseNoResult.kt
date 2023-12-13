package com.fourplay.network.usecase

interface BaseUseCaseNoResult<in Parameter> {
    suspend fun execute(param: Parameter)
}