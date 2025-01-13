package com.example.up.act.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.R

@Composable
fun Login(modifier : Modifier = Modifier) {

    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        .fillMaxSize()
    ){
        Column(modifier = Modifier
        ){
            Image( modifier = Modifier
                .size(40.dp),
                painter = painterResource(id = R.drawable.up_logo),
                contentDescription = "U.P."
            )
            Text(modifier = Modifier
                .padding(top = 24.dp),
                text = "Log In",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            CustomAuthTextField(
                title = "id",
                value = id,
                onValueChange = {id = it}
            )
            CustomAuthTextField(
                title = "pw",
                value = pw,
                onValueChange = {pw = it}
            )
        }
        Button(modifier = Modifier
            .align(Alignment.BottomCenter)
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
}

@Preview(showBackground = true)
@Composable
fun ShowLogin(){
    Login()
}