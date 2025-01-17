package com.example.up.act.cmt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.up.act.bar.InputBottomBar
import com.example.up.act.bar.TopBar
import com.example.up.data.cls.cmt.Cmt
import com.example.up.data.cls.main.vm.cmt.CmtVM
import com.example.up.item.CmtViewItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CmtView(
    navController: NavHostController,
    cmtLst: List<Cmt>,
    cmtVM: CmtVM,
    parentNavController: NavHostController
){
    var cmtTxt by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            InputBottomBar(
                value = cmtTxt,
                onValueChange = { cmtTxt = it }
            )
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
            ) {
                TopBar(navController = parentNavController,
                    bool = 1,
                    minusDp = 20
                )
                Text(modifier = Modifier
                    .padding(top = 24.dp, start = 8.dp),
                    text = "댓글",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                LazyColumn(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(cmtLst){ index, it ->
                        CmtViewItem(
                            cmt = it
                        ) {
                            navController.navigate("INCMT/${index}")
                        }
                    }
                }
            }
        }
    }
}