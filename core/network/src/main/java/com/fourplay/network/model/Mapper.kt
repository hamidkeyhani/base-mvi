package com.fourplay.network.model

interface Mapper<F,T> {

    fun mapFrom(from:F):T

}