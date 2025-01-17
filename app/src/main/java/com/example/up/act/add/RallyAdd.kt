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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.compose.LifecycleStartStopEffectScope
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.bar.TopBar
import com.example.up.act.itg.AddElement
import com.example.up.act.itg.CustomTextField
import com.example.up.act.itg.DatePickerField
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.vm.rally.RallyAddEnum
import com.example.up.data.cls.main.vm.rally.RallyAddVM
import com.example.up.ui.theme.FontDarkGray
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.TimeZone

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RallyAddView(navController: NavHostController){
    val viewModel : RallyAddVM = viewModel()

    val state by viewModel.state.collectAsState()

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    val todayTime = System.currentTimeMillis()

    // DatePicker
    val startDatePickerState = rememberDatePickerState(
        initialSelectedDateMillis = todayTime,
        initialDisplayMode = DisplayMode.Picker
    )
    val endDatePickerState = rememberDatePickerState(
        initialSelectedDateMillis = todayTime,
        initialDisplayMode = DisplayMode.Picker
    )

    if (state.showStart){
        DatePickerField(
            onDismiss = { viewModel.updateState(RallyAddEnum.SHOW_START, false) },
            onConfirm = {
                viewModel.updateState(RallyAddEnum.START_DATE, it)
            },
            datePickerState = startDatePickerState
        )
    }

    if (state.showEnd && !state.showStart){
        DatePickerField(
            onDismiss = { viewModel.updateState(RallyAddEnum.SHOW_END, false) },
            onConfirm = {
                viewModel.updateState(RallyAddEnum.END_DATE, it)
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
                    navController.popBackStack()
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

            TopBar(navController = navController, bool = 1)

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
                value = state.title,
                onValueChange = {
                    viewModel.updateState(RallyAddEnum.TITLE, it)
                },
                holder = "제목을 입력하기...",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            HorizontalDivider(modifier = Modifier
                .padding(top = 4.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
                    color = FontDarkGray,
                    thickness = 1.dp
            )
            AddElement(
                title = "카테고리",
                onValueChange = { viewModel.updateState(RallyAddEnum.CTG, it as Int) },
                selectIndex = state.ctg,
                categoryLst = LstInfo.rallyNGetCtgLst,
                modifier = Modifier
            )
            AddElement(
                title = "주최자",
                value = state.master,
                onValueChange = { viewModel.updateState(RallyAddEnum.MASTER, it as String) },
                holder = "주최자 입력하기...",
                modifier = Modifier
            )
            AddElement(
                title = "참가 대상",
                onValueChange = { viewModel.updateState(RallyAddEnum.PART, it as Int) },
                selectIndex = state.part,
                categoryLst = LstInfo.participantLst,
                modifier = Modifier
            )
            AddElement(
                title = "접수 기간",
                onValueChange = {
                    if(it as Boolean){
                        viewModel.updateState(RallyAddEnum.SHOW_START, true)
                    } else {
                        viewModel.updateState(RallyAddEnum.SHOW_END, true)
                    }
                },
                startDate = state.startDate,
                endDate = state.endDate,
                modifier = Modifier
            )
            AddElement(
                title = "접수 방법",
                value = state.apply,
                onValueChange = {viewModel.updateState(RallyAddEnum.APPLY, it as String)},
                holder = "접수 방법 입력하기...",
                modifier = Modifier
            )
            AddElement(
                title = "참가 비용",
                value = state.cost,
                onValueChange = {viewModel.updateState(RallyAddEnum.COST, it as String)},
                holder = "참가 비용 입력하기...",
                modifier = Modifier
            )
            AddElement(
                title = "해당 지역",
                onValueChange = { viewModel.updateState(RallyAddEnum.PLACE, it as Int)},
                selectIndex = state.place,
                categoryLst = LstInfo.placeLst,
                modifier = Modifier
            )
            AddElement(
                title = "시상 내역",
                value = state.price,
                onValueChange = {viewModel.updateState(RallyAddEnum.PRICE, it as String)},
                holder = "시상 내역 입력하기...",
                modifier = Modifier
            )
            AddElement(
                title = "홈페이지 링크",
                value = state.homeLink,
                onValueChange = {viewModel.updateState(RallyAddEnum.HOME_LINK, it as String)},
                holder = "링크 삽입하기...",
                modifier = Modifier
            )
            AddElement(
                title = "접수 링크",
                value = state.homeLink,
                onValueChange = {viewModel.updateState(RallyAddEnum.APPLY_LINK, it as String)},
                holder = "링크 삽입하기...",
                modifier = Modifier
            )
            AddElement(
                title = "문의처",
                value = state.contact,
                onValueChange = {viewModel.updateState(RallyAddEnum.CONTACT, it as String)},
                holder = "문의처 입력하기...",
                modifier = Modifier
            )
            AddElement(
                title = "기타 정보",
                value = state.etc,
                onValueChange = {viewModel.updateState(RallyAddEnum.ETC, it as String)},
                holder = "기타 정보 입력하기...",
                modifier = Modifier
            )
        }      
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowRallyAddView(){
    RallyAddView(rememberNavController())
}