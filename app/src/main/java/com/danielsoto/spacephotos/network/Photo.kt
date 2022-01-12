package com.danielsoto.spacephotos.network

import com.squareup.moshi.Json

data class Photo (
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
        )

