package com.example.up.item

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.data.LstInfo
import com.example.up.data.cls.cmt.Cmt
import com.example.up.ui.theme.FontDarkGray
import com.example.up.ui.theme.FontLightGray
import com.example.up.ui.theme.UPTheme
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CmtViewItem(
    cmt : Cmt,
    hideTxt : Boolean = false
){

    val cmtLstSize = cmt.cmtLst?.size ?:  0

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(
            if (cmt.cmtLst != null) Color.White else Color.Transparent,
            shape = RoundedCornerShape(12.dp)
        )
    ){
        Image(modifier = Modifier
            .padding(start = 12.dp, top = 12.dp)
            .size(28.dp)
            .background(Color.White)
            .clip(shape = CircleShape)
            .border(1.dp, color = FontDarkGray, shape = CircleShape),
            imageVector = Icons.Default.Person,
            contentDescription = "Person"
        )
        Column(modifier = Modifier
            .padding(start = 8.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
            .fillMaxWidth()
        ){
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(modifier = Modifier,
                    text = cmt.user,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Text(modifier = Modifier,
                    text = cmt.time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = FontDarkGray
                )
            }
            Text(modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
                text = cmt.body,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            // 답글이 없거나 hideTxt가 true면 표시안함
            if (cmt.cmtLst != null && !hideTxt){
                Text(modifier = Modifier
                    .padding(top = 8.dp),
                    text = "답글${
                        if(cmtLstSize != 0){
                            " ${cmtLstSize}개"
                        } else {
                            ""
                        }
                    } 보기",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = FontDarkGray
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = false)
@Composable
fun ShowCmtViewItem(){
    UPTheme {
        CmtViewItem(cmt = LstInfo.cmtLst[0])
    }
}