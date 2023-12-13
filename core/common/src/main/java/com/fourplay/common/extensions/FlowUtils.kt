package com.fourplay.common.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flattenMerge


fun <T> flattenMerge(vararg flows: Flow<T>): Flow<T> {
    return flows.asFlow().flattenMerge()
}
