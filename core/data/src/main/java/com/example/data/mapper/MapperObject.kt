package com.example.data.mapper

interface MapperObject<in E, out R> {
    fun transform(objects: E): R
}