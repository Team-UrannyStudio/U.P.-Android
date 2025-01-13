package com.example.up.act.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.data.cls.etc.HomeRowData
import com.example.up.data.LstInfo
import com.example.up.item.IntroItem
import com.example.up.item.PostItem
import com.example.up.ui.theme.FontDarkGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Home(modifier : Modifier) {
    val homeItemLst = listOf(
        HomeRowData(title = "대회안내", checkRally = true),
        HomeRowData(title = "구인공고"),
        HomeRowData(title = "커뮤니티", checkCom = true)
    )

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(homeItemLst) { homeRowData ->
            HomeLazyRow(
                title = homeRowData.title,
                checkRally = homeRowData.checkRally,
                checkCom = homeRowData.checkCom
            )
        }
    }
}

@Composable
fun LazyTitle(title : String){
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(36.dp)
    )
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            modifier = Modifier
                .padding(end = 12.dp)
                .align(Alignment.Bottom),
            text = "더보기",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = FontDarkGray
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeLazyRow(title : String, checkRally : Boolean, checkCom : Boolean){
    LazyTitle(title = title)
    if(checkCom){
        LazyColumn(
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 12.dp)
                .fillMaxSize(1f)
                .heightIn(max = 580.dp),
            verticalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            items(LstInfo.comPostLst){ i ->
                PostItem(
                    title = i.title,
                    category = i.category,
                    dateTime = i.createTime,
                    user = i.master,
                    cmtLst = i.cmtLst
                )
            }
        }
    } else {
        LazyRow(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(1f)
                .height(160.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            if(checkRally){
                items(LstInfo.rallyLst){ i ->
                    IntroItem(
                        title = i.title,
                        master = i.master,
                        category = i.category,
                        imgUrl = i.imgUrl,
                        startTime = i.startTime,
                        endTime = i.endTime
                    )
                }
            } else{
                items(LstInfo.getLst){ i ->
                    IntroItem(
                        title = i.title,
                        master = i.master,
                        category = i.category,
                        imgUrl = i.imgUrl,
                        work = i.work
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowHome(){
    Home(Modifier)
}