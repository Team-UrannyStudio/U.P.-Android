package com.example.up.act.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.R

@Composable
fun Profile(modifier : Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxSize()
    ){
        Column(modifier = Modifier
            .padding(start = 24.dp, top = 16.dp, end = 24.dp)
            .fillMaxWidth()
        ){
            Image( modifier = Modifier
                .size(40.dp),
                painter = painterResource(id = R.drawable.up_logo),
                contentDescription = "U.P."
            )
            Box(modifier = Modifier
                .padding(top = 24.dp)
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
            ){
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White, shape = CircleShape)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile"
                )
                Box(modifier = Modifier
                    .padding(end = 10.dp, bottom = 10.dp)
                    .size(40.dp)
                    .background(Color.White, shape = CircleShape)
                    .clip(CircleShape)
                    .align(Alignment.BottomEnd)
                ){
                    Image(modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.upload_img),
                        contentDescription = "profile"
                    )
                }
            }
            Text(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
                text = "이지호",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            ProfileElement(modifier = Modifier
                .align(Alignment.CenterHorizontally),
                title = "전화번호",
                value = "010 - 6969 - 7474"
            ) {
                
            }
            ProfileElement(modifier = Modifier
                .align(Alignment.CenterHorizontally),
                title = "포트폴리오",
                value = "byeongsin.kr"
            ) {

            }
        }
    }
}

@Composable
fun ProfileElement(
    modifier : Modifier = Modifier,
    title : String,
    value : String,
    onClick : () -> Unit
){
    Column(modifier = modifier
        .padding(top = 20.dp)
        .width(196.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth(),
            Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
            Text( modifier = Modifier
                .clickable { onClick() }
                .align(Alignment.CenterVertically),
                text = "변경",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
        }
        Text( modifier = Modifier
            .align(Alignment.Start),
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowProfile(){
    Profile(Modifier)
}