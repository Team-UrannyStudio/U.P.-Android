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
import androidx.compose.ui.unit.dp
import com.example.up.data.LstInfo
import com.example.up.item.CategoryItem
import com.example.up.item.IntroItem
import com.example.up.item.PostItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PageView(modifier : Modifier, type : Char) {

    var searchTxt by remember { mutableStateOf("") }

    Column(modifier = modifier
        .fillMaxSize(1f)
    ){
        LazyRow(modifier = Modifier
            .fillMaxWidth(1f),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            itemsIndexed(
                if(type == 'R' || type == 'G') LstInfo.rallyNGetCtgLst
                else LstInfo.comCtgLst,
            ){ i, data->
                CategoryItem(
                    text = data.title,
                    backColor = data.backColor,
                    textColor = data.txtColor
                ) { item ->
                    Log.d("Click", "Tag")
                }
            }
        }
        TextField( modifier = Modifier
            .padding(top = 16.dp, start = 12.dp, end = 12.dp)
            .fillMaxWidth(1f),
            value = searchTxt ,
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
                'G' -> {
                    items(LstInfo.getLst){ i ->
                        IntroItem(
                            title = i.title,
                            master = i.master,
                            category = i.category ,
                            imgUrl = i.imgUrl,
                            work = i.work,
                            checkHome = true
                        )
                    }
                }
                'R' -> {
                    items(LstInfo.rallyLst){ i ->
                        IntroItem(
                            title = i.title,
                            master = i.master,
                            category = i.category,
                            imgUrl = i.imgUrl,
                            startTime = i.startTime,
                            endTime = i.endTime,
                            checkHome = true
                        )
                    }
                }
            }
        }
    }
}