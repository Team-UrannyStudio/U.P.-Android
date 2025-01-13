package com.example.up.act.add

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.act.itg.AddElement
import com.example.up.act.itg.CustomTextField
import com.example.up.data.LstInfo
import com.example.up.ui.theme.FontDarkGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GetAddView(){

    val scrollState = rememberScrollState()

    var title by remember{ mutableStateOf("") }
    var work by remember{ mutableStateOf("") }
    var qualification by remember{ mutableStateOf("") }
    var preference by remember{ mutableStateOf("") }
    var contact by remember{ mutableStateOf("") }
    var introTxt by remember{ mutableStateOf("") }

    var selectCtgIndex by remember{ mutableIntStateOf(1) }

    Scaffold(modifier = Modifier,
        bottomBar = {
            Button(modifier = Modifier
                .padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(60.dp),
                onClick = {
                    Log.d("Click", "Clear")
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    text = "완료하기"
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(scrollState)
        ) {
            Box(modifier = Modifier
                .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 20.dp)
                .fillMaxWidth()
                .height(509.dp)
                .background(Color.White)
                .clip(RoundedCornerShape(4.dp))
            ){
                Text(modifier = Modifier
                    .align(Alignment.Center),
                    text = "사진 삽입하기"
                )
            }
            CustomTextField(
                value = title,
                onValueChange = { title = it },
                holder = "제목을 입력하기...",
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider(modifier = Modifier
                .padding(top = 4.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
                color = FontDarkGray,
                thickness = 1.dp
            )
            AddElement(
                title = "카테고리",
                onValueChange = { selectCtgIndex = it as Int },
                selectIndex = selectCtgIndex,
                categoryLst = LstInfo.rallyNGetCtgLst
            )
            AddElement(
                title = "주요 업무",
                value = work,
                onValueChange = { work = it as String},
                holder = "주최자 입력하기..."
            )
            AddElement(
                title = "자격 요건",
                value = qualification,
                onValueChange = { qualification = it as String},
                holder = "자격 요건 입력하기..."
            )
            AddElement(
                title = "우대 사항",
                value = preference,
                onValueChange = {preference = (it as String)},
                holder = "우대 사항 입력하기..."
            )
            AddElement(
                title = "문의처 링크",
                value = contact,
                onValueChange = {contact = (it as String)},
                holder = "문의처 링크 입력하기..."
            )
            AddElement(
                title = "소개글",
                value = introTxt,
                onValueChange = {introTxt = (it as String)},
                holder = "소개글 입력하기..."
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowGetAddView(){
    GetAddView()
}