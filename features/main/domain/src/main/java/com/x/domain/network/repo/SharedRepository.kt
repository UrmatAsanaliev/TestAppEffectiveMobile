package com.x.domain.network.repo

interface SharedRepository {

    fun getCity(): String

    fun putCity(city: String)
}