package com.base.network.model

interface Mapper<F,T> {

    fun mapFrom(from:F):T

}