package com.example.up.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import androidx.compose.ui.graphics.Color
import com.example.up.data.cls.cmt.Cmt
import com.example.up.data.cls.main.ComPst
import com.example.up.data.cls.etc.Ctg
import com.example.up.data.cls.main.GetPst
import com.example.up.data.cls.main.RallyPst
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
object LstInfo {
    // 대회 모집 글
    val rallyLst = arrayListOf<RallyPst>().apply {
        repeat(10){ i->
            add(
                RallyPst(
                    category = "IT-소프트웨어",
                    imgUrl = "https://media.istockphoto.com/id/2039918088/ko/%EC%82%AC%EC%A7%84/%EC%A7%91%EC%97%90%EC%84%9C-%EC%95%84%EB%8A%91%ED%95%9C-%EC%86%8C%ED%8C%8C%EC%97%90%EC%84%9C-%ED%83%9C%EB%B8%94%EB%A6%BF%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%ED%96%89%EB%B3%B5%ED%95%9C-%EC%95%84%ED%94%84%EB%A6%AC%EC%B9%B4%EA%B3%84-%EB%AF%B8%EA%B5%AD%EC%9D%B8-%EC%97%AC%EC%84%B1.jpg?s=1024x1024&w=is&k=20&c=YHUO_rEadNQ9HLUqnmAOa6SVwAYI-JMo40cXnwTgmI4=",
                    title = "같이 스택 나갈 서버, 웹, 앱,",
                    master = "sk telecom",
                    participant = "아무나",
                    startTime = LocalDate.of(2024, 10, 16),
                    endTime = LocalDate.of(2024, 11, 30),
                    place = "온라인",
                    price = "1등 100만원",
                    homePageLink = "https://www.saramin.co.kr/zf_user/",
                    apply = "온라인 신청",
                    applyLink = "https://www.saramin.co.kr/zf_user/",
                    cost = "없음",
                    contact = "010-2520-6780",
                    etc = "기타기타",
                    createTime = LocalDateTime.of(2024, 12, 12, 21, 2, 1)
                )
            )
        }
    }
    // 구인 공고 글
    val getLst = arrayListOf<GetPst>().apply {
        repeat(10){ i->
            add(
                GetPst(
                    title = "같이 스택 나갈 서버, 웹, 앱,",
                    category = "IT-소프트웨어",
                    imgUrl = "https://media.istockphoto.com/id/2039918088/ko/%EC%82%AC%EC%A7%84/%EC%A7%91%EC%97%90%EC%84%9C-%EC%95%84%EB%8A%91%ED%95%9C-%EC%86%8C%ED%8C%8C%EC%97%90%EC%84%9C-%ED%83%9C%EB%B8%94%EB%A6%BF%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%ED%96%89%EB%B3%B5%ED%95%9C-%EC%95%84%ED%94%84%EB%A6%AC%EC%B9%B4%EA%B3%84-%EB%AF%B8%EA%B5%AD%EC%9D%B8-%EC%97%AC%EC%84%B1.jpg?s=1024x1024&w=is&k=20&c=YHUO_rEadNQ9HLUqnmAOa6SVwAYI-JMo40cXnwTgmI4=",
                    work = "주요업무 : 서비스 개발",
                    qualification = "개발 할 줄 아는 사람",
                    preference = "서버 경력 3년 이상",
                    introTxt = "우리 프로젝트 좋아요",
                    contact = "https://uranny.com",
                    master = "sk telecom",
                    cmtLst = arrayListOf(
                        Cmt(
                            user = "Uranny",
                            time = LocalDateTime.of(2024, 10, 20, 21, 21, 21),
                            imgUrl = "string",
                            body = "zzzzzzzzzzzzzzzzzZzzzzzzzzZZzzZzzzZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz",
                            cmtLst = arrayListOf()
                        )
                    ),
                    createTime = LocalDateTime.of(2024, 12, 2, 3, 2, 2)
                )
            )
        }
    }
    // 커뮤니티 글
    val comPostLst = arrayListOf<ComPst>().apply {
        repeat(10){ i->
            add(
                ComPst(
                    title = "야이 게이들아",
                    category = "공지사항",
                    imageUrl = "https://uranny.com",
                    body = "게이들",
                    master = "Uranny",
                    cmtLst = arrayListOf(),
                    createTime = LocalDateTime.of(2024, 12, 2, 3, 2, 2)
                )
            )
        }
    }

    val rallyNGetCtgLst = arrayListOf<Ctg>(
        Ctg(
            title = "전체",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "문학",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "학•논문",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "과학•기술",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "IT•소프트웨어",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "스포츠",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "미술•디자인",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "만화•캐릭터",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "음악",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "댄스",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "오디션",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "사진",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "영어",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "아이디어",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "산업",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "음식",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "기타",
            backColor = Color.White,
            txtColor = Color.Black
        )
    )

    val comCtgLst = arrayListOf(
        Ctg(
            title = "전체",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "잡담",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "창작",
            backColor = Color.White,
            txtColor = Color.Black
        ),
        Ctg(
            title = "공지사항",
            backColor = Color.White,
            txtColor = Color.Black
        )
    )

    val participantLst = arrayListOf(
        Ctg(
            title = "전체",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "아무나",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "초등학생",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "중학생",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "고등학생",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "대학생",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "대학원생",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "외국인",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "일반인",
            backColor = Color.Black,
            txtColor = Color.White
        )
    )

    val placeLst = arrayListOf(
        Ctg(
            title = "전체",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "온라인",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "특별시·광역시·특별자치시",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "도·특별자치도",
            backColor = Color.Black,
            txtColor = Color.White
        ),
        Ctg(
            title = "기타",
            backColor = Color.Black,
            txtColor = Color.White
        )
    )

    val cmtLst = arrayListOf(
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,34, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf(
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                ),
                Cmt(
                    user = "Uranny",
                    time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
                    imgUrl = "String",
                    body = "weroiqgonqwuviewymcuyuiqmf"
                )
            )
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf(

            )
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        ),
        Cmt(
            user = "Uranny",
            time = LocalDateTime.of(2024, 12, 12, 12,12, 12),
            imgUrl = "String",
            body = "weroiqgonqwuviewymcuyuiqmf",
            cmtLst = arrayListOf()
        )
    )


}