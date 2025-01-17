package com.example.up.act.bar

import android.graphics.drawable.PaintDrawable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.up.R
import com.example.up.data.cls.main.vm.main.MainViewModel

@Composable
fun TopBar(bool : Int = 0,
           navController : NavHostController,
           minusDp : Int = 0,
           onClick : () -> Unit = {}
){

    Row(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxWidth()
        .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ){
        Image(modifier = Modifier
            .height(40.dp)
            .padding(start = (24 - minusDp).dp),
            painter = painterResource(id = R.drawable.up_logo),
            contentDescription = "Logo",
        )

        when(bool){
            1 -> {
                Image(modifier = Modifier
                    .height(36.dp)
                    .padding(end = (24 - minusDp).dp)
                    .clickable {
                        Log.d("navStack", "before pop : ${navController.currentBackStackEntry}")
                        navController.popBackStack()
                        Log.d("navStack", "after pop : ${navController.currentBackStackEntry}")
                    },
                    painter = painterResource(
                        id = R.drawable.back_btn,
                    ),
                    contentDescription = "BackBtn"
                )
            }

            2 -> {
                Box(modifier = Modifier
                    .padding(end = 12.dp)
                    .background(
                        Color.Black,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .width(106.dp)
                    .height(32.dp)
                    .clickable {
                        onClick()
                    }
                ){
                    Text(modifier = Modifier
                        .align(Alignment.Center),
                        text = "게시글 작성하기",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            else -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTopBar(){
    val navController = rememberNavController()
    TopBar(bool = 0, navController = navController)
}