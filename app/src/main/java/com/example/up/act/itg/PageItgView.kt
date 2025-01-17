package com.example.up.act.itg

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.bar.TopBar
import com.example.up.data.LstInfo
import com.example.up.item.CategoryItem
import com.example.up.item.IntroItem
import com.example.up.item.PostItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PageView(modifier : Modifier,
             type : Char,
             navController : NavHostController,
             onClick : (String) -> Unit,
             onAddClick : (String) -> Unit
) {

    var searchTxt by remember { mutableStateOf("") }
    var selectIndex by remember { mutableStateOf(0)}

    Column(modifier = modifier
        .fillMaxSize(1f)
    ){
        TopBar(2,
            navController
        ){
            onAddClick("ADD/${type}")
        }

        LazyRow(modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth(1f),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            itemsIndexed(
                if(type == 'R' || type == 'G') LstInfo.rallyNGetCtgLst
                else LstInfo.comCtgLst,
            ){ index, data->
                CategoryItem(
                    text = data.title,
                    backColor = if(selectIndex == index) Color.Black else Color.White,
                    textColor = if(selectIndex == index) Color.White else Color.Black
                ) { item ->
                    selectIndex = index
                }
            }
        }
        TextField( modifier = Modifier
            .padding(top = 16.dp, start = 12.dp, end = 12.dp)
            .fillMaxWidth(1f),
            value = searchTxt,
            onValueChange = {
                searchTxt = it
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                errorContainerColor = Color.White
            ),
            trailingIcon = {
                Icon(modifier = Modifier
                    .size(24.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            singleLine = true,
            placeholder = {
                Text(text = "검색어를 입력해주세요...")
            },
            shape = RoundedCornerShape(8.dp)
        )
        LazyColumn(modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(1f),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp, bottom = 16.dp),
            verticalArrangement = if(type != 'C') Arrangement.spacedBy(16.dp) else Arrangement.spacedBy(8.dp)
        ) {
            when(type){
                'C' -> {
                    itemsIndexed(LstInfo.comPostLst){ index, data ->
                        PostItem(
                            title = data.title,
                            category = data.category,
                            dateTime = data.createTime,
                            user = data.master,
                            cmtLst = data.cmtLst
                        ){
                            onClick("ComPost/${index}")
                        }
                    }
                }
                'G' -> {
                    itemsIndexed(LstInfo.getLst){ index, data ->
                        IntroItem(
                            title = data.title,
                            master = data.master,
                            category = data.category ,
                            imgUrl = data.imgUrl,
                            work = data.work,
                            checkHome = true
                        ) {
                            onClick("GetPost/${index}")
                        }
                    }
                }
                'R' -> {
                    itemsIndexed(LstInfo.rallyLst){ index, data ->
                        IntroItem(
                            title = data.title,
                            master = data.master,
                            category = data.category,
                            imgUrl = data.imgUrl,
                            startTime = data.startTime,
                            endTime = data.endTime,
                            checkHome = true
                        ) {
                            onClick("RallyPost/${index}")
                        }
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = false)
@Composable
fun ShowPageView(){
    val navController = rememberNavController()
    PageView(Modifier,
        'R',
        navController,
        onClick = {},
        onAddClick = {}
    )
}