package com.alisdn.samplemvvmandroid.data

import com.alisdn.samplemvvmandroid.domain.Cat

data class CatResponse(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)

fun CatResponse.toCat(): Cat {
    return Cat(
        id = id,
        url = url,
        width = width,
        height = height
    )
}