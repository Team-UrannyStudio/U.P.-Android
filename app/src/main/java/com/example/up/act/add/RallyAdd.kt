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
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
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
import com.example.up.act.itg.DatePickerField
import com.example.up.data.LstInfo
import com.example.up.ui.theme.FontDarkGray

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RallyAddView(){

    val scrollState = rememberScrollState()

    var title by remember{ mutableStateOf("") }
    var master by remember{ mutableStateOf("") }
    var apply by remember{ mutableStateOf("") }
    var cost by remember{ mutableStateOf("") }
    var price by remember{ mutableStateOf("") }
    var homePageLink by remember{ mutableStateOf("") }
    var applyLink by remember{ mutableStateOf("") }
    var contact by remember{ mutableStateOf("") }
    var etc by remember{ mutableStateOf("") }

    var selectCtgIndex by remember{ mutableIntStateOf(1) }
    var selectPlaceIndex by remember{ mutableIntStateOf(1) }
    var selectPartIndex by remember{ mutableIntStateOf(1) }

    var selectStartDate by remember{ mutableStateOf("") }
    var selectEndDate by remember{ mutableStateOf("") }

    var showStartCalendar by remember { mutableStateOf(false) }
    var showEndCalendar by remember { mutableStateOf(false) }

    // DatePicker
    val startDatePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
    val endDatePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)

    if (showStartCalendar){
        DatePickerField(
            onDismiss = { showStartCalendar = false },
            onConfirm = {
                selectStartDate = it
            },
            datePickerState = startDatePickerState
        )
    }

    if (showEndCalendar && !showStartCalendar){
        DatePickerField(
            onDismiss = { showEndCalendar = false },
            onConfirm = {
                selectEndDate = it
            },
            datePickerState = endDatePickerState
        )
    }
    
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
                title = "주최자",
                value = master,
                onValueChange = { master = it as String},
                holder = "주최자 입력하기..."
            )
            AddElement(
                title = "참가 대상",
                onValueChange = {selectPartIndex = it as Int},
                selectIndex = selectPartIndex,
                categoryLst = LstInfo.participantLst
            )
            AddElement(
                title = "접수 기간",
                onValueChange = {
                    if(it as Boolean){
                        showStartCalendar = true
                    } else {
                        showEndCalendar = true
                    }
                },
                startDate = selectStartDate,
                endDate = selectEndDate
            )
            AddElement(
                title = "접수 방법",
                value = apply,
                onValueChange = {apply = (it as String)},
                holder = "접수 방법 입력하기..."
            )
            AddElement(
                title = "참가 비용",
                value = cost,
                onValueChange = {cost = (it as String)},
                holder = "참가 비용 입력하기..."
            )
            AddElement(
                title = "해당 지역",
                onValueChange = { selectPlaceIndex = (it as Int)},
                selectIndex = selectPlaceIndex,
                categoryLst = LstInfo.placeLst
            )
            AddElement(
                title = "시상 내역",
                value = price,
                onValueChange = {price = (it as String)},
                holder = "시상 내역 입력하기..."
            )
            AddElement(
                title = "홈페이지 링크",
                value = homePageLink,
                onValueChange = {homePageLink = (it as String)},
                holder = "링크 삽입하기..."
            )
            AddElement(
                title = "접수 링크",
                value = applyLink,
                onValueChange = {applyLink = (it as String)},
                holder = "링크 삽입하기..."
            )
            AddElement(
                title = "문의처",
                value = contact,
                onValueChange = {contact = (it as String)},
                holder = "문의처 입력하기..."
            )
            AddElement(
                title = "기타 정보",
                value = etc,
                onValueChange = {etc = (it as String)},
                holder = "기타 정보 입력하기..."
            )
        }      
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowRallyAddView(){
    RallyAddView()
}