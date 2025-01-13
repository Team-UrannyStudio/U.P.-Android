package com.example.up.data.cls.main

data class PostElementData(
    val title : String,
    val body : String,
    val hyper : Boolean = false,
    val imgUrl : String? = null,
    val checkTitle : Boolean = true
)
