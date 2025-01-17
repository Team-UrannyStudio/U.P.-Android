package com.example.up.data.cls.main

import com.example.up.data.cls.cmt.Cmt

interface PostData {
    fun toData() : PostBasic
    fun toDataLst() : List<PostElementData>
    fun toCmtLst() : List<Cmt>
}