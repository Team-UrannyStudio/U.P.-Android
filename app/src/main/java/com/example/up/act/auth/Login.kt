package com.example.up.act.auth

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.up.data.cls.main.vm.auth.AuthValue.*

@Composable
fun Login(modifier : Modifier = Modifier,
          navController : NavHostController,
          authVM : AuthVM
) {
    val context = LocalContext.current
    val id by authVM.id.collectAsState()
    val pw by authVM.pw.collectAsState()

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
                onValueChange = {authVM.updateValue(ID, it)}
            )
            CustomAuthTextField(
                title = "pw",
                value = pw,
                onValueChange = {authVM.updateValue(PW, it)}
            )
        }
        Button(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(60.dp),
            onClick = {
                if(id == "ojm67800" && pw == "12345678"){
                    listOf(ID, PW).forEach { item ->
                        authVM.resetValue(item)
                    }
                    navController.navigate("MAIN") {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true } // 스택 제거
                        launchSingleTop = true // 동일 화면 중복 방지
                    }
                    Log.d("Click", "Clear")
                } else {
                    Toast.makeText(context, "아이디 또는 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                }
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
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLogin(){
    val navController = rememberNavController()
    val authVM : AuthVM = viewModel()
    Login(navController = navController, authVM = authVM)
}