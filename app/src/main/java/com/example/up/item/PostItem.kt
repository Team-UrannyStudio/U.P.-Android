package com.example.up.item

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.up.data.cls.cmt.Cmt
import com.example.up.ui.theme.FontDarkGray
import com.example.up.ui.theme.FontGray
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostItem(
    title: String,
    category: String,
    dateTime: LocalDateTime,
    user: String,
    cmtLst: List<Cmt>,
    isCurrent : Boolean = false,
    onClick : () -> Unit
) {
    Box(
        modifier = if(isCurrent){
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(
                    FontGray,
                    shape = RoundedCornerShape(4.dp)
                )
            } else {
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(
                    Color.White,
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable { onClick() }
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top // Row 내부 요소를 위쪽에 정렬
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = category,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = FontDarkGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = FontDarkGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = user,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = FontDarkGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Text(
                text = cmtLst.size.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = FontDarkGray,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowPostItem(){
    PostItem(title = "같이 스택나갈 서버, 웹, 앱, 디자인 분 구합니다.adfsfvnutqyvniyvtivqniytvieynwoveintwyiuqvneitoyqnvtyinqiovhtinui",
        category = "공지사항",
        dateTime = LocalDateTime.now() ,
        user = "Uranny",
        cmtLst = ArrayList()
    ){

    }
}