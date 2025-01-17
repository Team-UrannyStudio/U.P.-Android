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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.up.data.cls.main.vm.auth.AuthValue

@Composable
fun SignupA(modifier : Modifier = Modifier,
            navController : NavHostController,
            authVM : AuthVM
){
    val name by authVM.name.collectAsState()
    val tel by authVM.tel.collectAsState()
    val ptp by authVM.ptp.collectAsState()

    val context = LocalContext.current

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
                text = "Sign Up",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            CustomAuthTextField(
                title = "이름",
                value = name,
                onValueChange = {authVM.updateValue(AuthValue.NAME, it)}
            )
            CustomAuthTextField(
                title = "전화번호",
                value = tel,
                onValueChange = {authVM.updateValue(AuthValue.TEL, it)}
            )
            CustomAuthTextField(
                title = "포트폴리오 링크",
                value = ptp,
                onValueChange = {authVM.updateValue(AuthValue.PTP, it)}
            )
        }
        Button(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(60.dp),
            onClick = {
                if(name.isNotEmpty() &&
                    tel.isNotEmpty() &&
                    ptp.isNotEmpty()
                    ) {
                    navController.navigate("SIGNUPB")
                    Log.d("Click", "Clear")
                } else {
                    Toast.makeText(context, "빈칸을 입력 해주세요", Toast.LENGTH_SHORT).show()
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
                text = "다음으로"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSignupA(){
    val navController = rememberNavController()
    val authVM : AuthVM = viewModel()
    SignupA(navController = navController, authVM = authVM)
}