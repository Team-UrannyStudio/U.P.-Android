package com.example.up.data.cls.main

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.up.data.cls.cmt.Cmt
import java.time.LocalDateTime

data class ComPst(
    val id : Long,
    val title : String,
    val category: String,
    val imageUrl : String,
    val body : String,
    val master : String,
    val cmtLst : ArrayList<Cmt>,
    val createTime : LocalDateTime
) : PostData {
    override fun toData(): PostBasic = PostBasic(
        title = title,
        category = category,
        master = master,
        createTime = createTime,
        communityBody = body
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun toDataLst(): List<PostElementData> = listOf(
        PostElementData(
            title = "댓글${if(!(cmtLst.size == 0)) cmtLst.size else ""}",
            body = if(!(cmtLst.size == 0)) cmtLst[0].body else "댓글이 없습니다",
            imgUrl = if(!(cmtLst.size == 0)) cmtLst[0].imgUrl else null
        ),
    )

    override fun toCmtLst(): List<Cmt> {
        return cmtLst
    }

    fun toComPst() : ComPst = ComPst(id, title, category, imageUrl, body, master, cmtLst, createTime)
}