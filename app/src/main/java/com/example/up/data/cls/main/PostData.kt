package com.example.up.data.cls.main

interface PostData {
    fun toData() : PostBasic
    fun toDataLst() : List<PostElementData>
}