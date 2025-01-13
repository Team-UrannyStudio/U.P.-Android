package com.example.up.data.cls.main

import com.example.up.data.cls.cmt.Cmt
import java.time.LocalDateTime

data class GetPst(
    val title: String,
    val category: String,
    val imgUrl: String,
    val work : String,
    val qualification : String,
    val preference : String,
    val introTxt : String,
    val contact : String,
    val master: String,
    val cmtLst : ArrayList<Cmt>,
    val createTime : LocalDateTime
) : PostData {
    override fun toData(): PostBasic = PostBasic(
        title = title,
        category = category,
        master = master,
        createTime = createTime
    )
    override fun toDataLst(): List<PostElementData> = listOf(
        PostElementData(title = "주요 업무", body = work),
        PostElementData(title = "자격 요건", body = qualification),
        PostElementData(title = "우대 사항", body = preference),
        PostElementData(title = "문의처 링크", body = contact, hyper = true),
        PostElementData(title = "소개글", body = introTxt),
        PostElementData(
            title = "댓글${if(!(cmtLst.size == 0)) cmtLst.size else ""}",
            body = if(!(cmtLst.size == 0)) cmtLst[0].body else "댓글이 없습니다",
            imgUrl = if(!(cmtLst.size == 0)) cmtLst[0].imgUrl else null
        )
    )
}