package com.example.up.item

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.up.ui.theme.FontGray
import com.example.up.ui.theme.TranBlack
import com.example.up.ui.theme.TranWhite
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalGlideComposeApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun IntroItem(
    title: String,
    startTime: LocalDate? = null,
    endTime: LocalDate? = null,
    work : String? = null,
    master: String,
    category: String,
    imgUrl: String,
    checkHome : Boolean = false,
    onClick : () -> Unit
) {
    Box(
        modifier =
        if (checkHome){
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable { onClick() }
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
        }
        else {
            Modifier
                .width(300.dp)
                .height(160.dp)
                .clickable { onClick() }
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
        }
    ) {
        if (checkHome){
            IntroItemView(
                title = title,
                startTime = startTime,
                endTime = endTime,
                work = work,
                master = master,
                category = category,
                imgUrl = imgUrl,
                addDp = 4
            )
        } else{
            IntroItemView(
                title = title,
                startTime = startTime,
                endTime = endTime,
                work = work,
                master = master,
                category = category,
                imgUrl = imgUrl
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun IntroItemView(
    title: String,
    startTime: LocalDate? = null,
    endTime: LocalDate? = null,
    work : String? = null,
    master: String,
    category: String,
    imgUrl: String,
    addDp : Int = 0
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f))
    ) {
        Box(modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = (8+addDp).dp, end = (8+addDp).dp)
        ){
            CategoryItem(
                text = category,
                isClick = false,
                backColor = TranWhite,
                textColor = TranBlack
            ) { item ->
                Log.d("Click", "Tag")
            }
        }
        Row(modifier = Modifier
            .padding(
                bottom = (12+addDp).dp,
                start = (12+addDp).dp,
                end = (12+addDp).dp
            )
            .align(Alignment.BottomStart)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(modifier = Modifier
                .weight(1f, fill = false),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Text(modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if(work == null){
                    Text(modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth(),
                        text =
                        "${startTime!!.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))} ~ ${endTime!!.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}",
                        color = FontGray,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                } else{
                    Text(modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth(),
                        text = work!!,
                        color = FontGray,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text(modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                    text = master,
                    color = FontGray,
                    fontSize = 12.sp,
                    maxLines = 1
                )
            }
            Box(modifier = Modifier
                .align(Alignment.Bottom)
            ){
                Icon(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Fav",
                    tint = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = false )
@Composable
fun ShowIntroItem() {
    IntroItem(
        title = "같이 스택 나갈 서버, 웹, 앱,",
        master = "sk telecom",
        startTime = LocalDate.of(2024, 10, 16),
        endTime = LocalDate.of(2024, 11, 30),
        work = "주요 업무 : 서버, 앱, 웹, 디자인",
        category = "IT-소프트웨어",
        imgUrl = "https://media.istockphoto.com/id/2039918088/ko/%EC%82%AC%EC%A7%84/%EC%A7%91%EC%97%90%EC%84%9C-%EC%95%84%EB%8A%91%ED%95%9C-%EC%86%8C%ED%8C%8C%EC%97%90%EC%84%9C-%ED%83%9C%EB%B8%94%EB%A6%BF%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%ED%96%89%EB%B3%B5%ED%95%9C-%EC%95%84%ED%94%84%EB%A6%AC%EC%B9%B4%EA%B3%84-%EB%AF%B8%EA%B5%AD%EC%9D%B8-%EC%97%AC%EC%84%B1.jpg?s=1024x1024&w=is&k=20&c=YHUO_rEadNQ9HLUqnmAOa6SVwAYI-JMo40cXnwTgmI4="
    ){

    }
}
