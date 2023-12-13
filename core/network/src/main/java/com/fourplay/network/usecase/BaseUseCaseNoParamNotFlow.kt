package com.fourplay.network.usecase

interface BaseUseCaseNoParamNotFlow<out Result> {
    suspend fun execute(): Result
}
