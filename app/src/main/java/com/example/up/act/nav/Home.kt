package com.example.up.act.nav

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.bar.TopBar
import com.example.up.data.cls.etc.HomeRowData
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.vm.main.MainViewModel
import com.example.up.data.cls.nav.BottomNavItem
import com.example.up.item.IntroItem
import com.example.up.item.PostItem
import com.example.up.ui.theme.FontDarkGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Home(modifier : Modifier,
         navController : NavHostController,
         mainVM : MainViewModel
) {
    val homeItemLst = listOf(
        HomeRowData(title = "대회안내", checkRally = true),
        HomeRowData(title = "구인공고"),
        HomeRowData(title = "커뮤니티", checkCom = true)
    )
    
    val navItemMap = mapOf(
        "대회안내" to "RallyPost",
        "구인공고" to "GetPost",
        "커뮤니티" to "ComPost"
    )

    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            TopBar(0, navController)
        }

        items(homeItemLst) { homeRowData ->
            HomeLazyRow(
                title = homeRowData.title,
                checkRally = homeRowData.checkRally,
                checkCom = homeRowData.checkCom,
                mainVM = mainVM,
                onClick = {
                    Log.d("ComPost", "HomeLazyRow2 : $it")
                    navController.navigate("${navItemMap[homeRowData.title]}/$it"){
                        popUpTo("MAIN") {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun LazyTitle(title : String,
              mainVM: MainViewModel
){
    val navItemMap = mapOf(
        "대회안내" to 1,
        "구인공고" to 2,
        "커뮤니티" to 3
    )

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
                .align(Alignment.Bottom)
                .clickable {
                    val result = navItemMap.getOrDefault(title, 0)
                    mainVM.changeIndex(result)
                },
            text = "더보기",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = FontDarkGray
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeLazyRow(title : String,
                checkRally : Boolean,
                checkCom : Boolean,
                mainVM: MainViewModel,
                onClick : (Int) -> Unit
){
    LazyTitle(title = title, mainVM = mainVM)
    if(checkCom){
        LazyColumn(
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 12.dp)
                .fillMaxSize(1f)
                .heightIn(max = 580.dp),
            verticalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            itemsIndexed(LstInfo.comPostLst){ index, data ->
                PostItem(
                    title = data.title,
                    category = data.category,
                    dateTime = data.createTime,
                    user = data.master,
                    cmtLst = data.cmtLst
                ){
                    onClick(index)
                }
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
                itemsIndexed(LstInfo.rallyLst){ index, data ->
                    IntroItem(
                        title = data.title,
                        master = data.master,
                        category = data.category,
                        imgUrl = data.imgUrl,
                        startTime = data.startTime,
                        endTime = data.endTime
                    ){
                        onClick(index)
                    }
                }
            } else{
                itemsIndexed(LstInfo.getLst){ index, data ->
                    IntroItem(
                        title = data.title,
                        master = data.master,
                        category = data.category,
                        imgUrl = data.imgUrl,
                        work = data.work
                    ){
                        onClick(index)
                    }
                }
            }
        }
    }
}