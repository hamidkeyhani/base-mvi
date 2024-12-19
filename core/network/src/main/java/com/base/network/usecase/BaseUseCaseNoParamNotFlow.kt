package com.base.network.usecase

interface BaseUseCaseNoParamNotFlow<out Result> {
    suspend fun execute(): Result
}
