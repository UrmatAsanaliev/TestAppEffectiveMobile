package com.x.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}