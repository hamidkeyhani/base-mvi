package com.base.network.usecase
import kotlinx.coroutines.flow.Flow


interface BaseUseCase<in Parameter, out Result> {
    suspend fun execute(param: Parameter): Flow<Result>
}