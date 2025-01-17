package com.example.up.data.cls.main

import com.example.up.data.cls.cmt.Cmt
import java.time.LocalDate
import java.time.LocalDateTime

data class RallyPst(
    val id : Long,
    val title: String,
    val category: String,
    val imgUrl: String, // imgurl
    val master: String, // 주최자
    val participant : String, // 참가 대상
    val startTime: LocalDate, // 시작일
    val endTime: LocalDate, // 마감일
    val place : String, // 해당 지역
    val price : String, // 시상 내역
    val homePageLink : String, // 홈페이지 링크
    val apply : String, // 접수 방법
    val applyLink : String, // 접수 링크
    val cost : String, // 참가 비용
    val contact : String, // 문의처
    val etc: String, // 기타 정보
    val createTime : LocalDateTime
) : PostData {
    override fun toData(): PostBasic = PostBasic(
        title = title,
        category = category,
        master = master,
        createTime = createTime
    )
    override fun toDataLst(): List<PostElementData> = listOf(
        PostElementData(title = "참가 대상", body = participant),
        PostElementData(title = "접수 기간", body = "${startTime} ~ ${endTime}"),
        PostElementData(title = "접수 방법", body = apply),
        PostElementData(title = "참가 비용", body = cost),
        PostElementData(title = "해당 지역", body = place),
        PostElementData(title = "시상 내역", body = price),
        PostElementData(title = "홈페이지 링크", body = homePageLink, hyper = true),
        PostElementData(title = "접수 링크", body = applyLink, hyper = true),
        PostElementData(title = "문의처", body = contact),
        PostElementData(title = "기타 정보", body = etc)
    )

    override fun toCmtLst(): List<Cmt> {
        return listOf()
    }
}
