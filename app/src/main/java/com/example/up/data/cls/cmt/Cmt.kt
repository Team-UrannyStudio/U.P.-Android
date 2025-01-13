package com.example.up.data.cls.cmt

import java.time.LocalDateTime

data class Cmt(
    val user : String,
    val time : LocalDateTime,
    val imgUrl : String,
    val body : String,
    val cmtLst : ArrayList<Cmt>? = null
)