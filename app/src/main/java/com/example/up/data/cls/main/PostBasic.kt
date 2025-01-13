package com.example.up.data.cls.main

import java.time.LocalDateTime

data class PostBasic(
    val title : String,
    val category: String,
    val master : String,
    val createTime : LocalDateTime,
    val communityBody : String? = null
)
