package com.example.up.act.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.R
import com.example.up.data.cls.main.vm.auth.AuthVM
import com.example.up.data.cls.main.vm.auth.AuthValue
import com.example.up.data.cls.main.vm.auth.AuthValue.ID
import com.example.up.data.cls.main.vm.auth.AuthValue.PW

@Composable
fun Start(modifier : Modifier = Modifier,
          navController : NavHostController,
          authVM: AuthVM
){
    Box(modifier = Modifier
        .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        .fillMaxSize()
    ){
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
        ){
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ){
                Image( modifier = Modifier
                    .align(Alignment.Center)
                    .height(120.dp),
                    painter = painterResource(id = R.drawable.start_logo),
                    contentDescription = "U.P."
                )
            }
            Button(modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(60.dp),
                onClick = {
                    listOf(ID, PW).forEach { item ->
                        authVM.resetValue(item)
                    }
                    navController.navigate("LOGIN")
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
                    text = "로그인"
                )
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
                onClick = {
                    listOf(
                        AuthValue.NAME,
                        AuthValue.TEL,
                        AuthValue.PW,
                        AuthValue.EMAIL,
                        AuthValue.ID,
                        AuthValue.PTP,
                        AuthValue.PW_CHECK
                    ).forEach {
                        authVM.resetValue(it)
                    }
                    navController.navigate("SIGNUPA")
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
                    text = "회원가입"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowStart(){
    val navController = rememberNavController()
    Start(navController = navController,
        authVM = viewModel()
    )
}