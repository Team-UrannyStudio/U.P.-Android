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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.R
import com.example.up.data.cls.main.vm.auth.AuthVM
import com.example.up.data.cls.main.vm.auth.AuthValue
import com.example.up.ui.theme.BtnGray

@Composable
fun SignupB(modifier : Modifier = Modifier,
            curNavController: NavHostController,
            authVM : AuthVM
){
    val id by authVM.id.collectAsState()
    val email by authVM.email.collectAsState()
    val pw by authVM.pw.collectAsState()
    val pwCheck by authVM.pwCheck.collectAsState()

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
                title = "email",
                value = email,
                onValueChange = {authVM.updateValue(AuthValue.EMAIL, it)}
            )
            CustomAuthTextField(
                title = "id",
                value = id,
                onValueChange = {authVM.updateValue(AuthValue.ID, it)}
            )
            CustomAuthTextField(
                title = "pw",
                value = pw,
                onValueChange = {authVM.updateValue(AuthValue.PW, it)}
            )
            CustomAuthTextField(
                title = "pw 확인",
                value = pwCheck,
                onValueChange = {authVM.updateValue(AuthValue.PW_CHECK, it)}
            )
        }
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
        ){
            Button(modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
                .height(60.dp),
                onClick = {
                    curNavController.popBackStack()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = BtnGray
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    text = "이전"
                )
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
                onClick = {
                    if(email.isNotEmpty() &&
                        id.isNotEmpty() &&
                        pw.isNotEmpty() &&
                        pwCheck.isNotEmpty()
                        ){
                        curNavController.popBackStack("START", inclusive = false)
                        listOf(AuthValue.NAME,
                            AuthValue.TEL,
                            AuthValue.PW,
                            AuthValue.EMAIL,
                            AuthValue.ID,
                            AuthValue.PTP,
                            AuthValue.PW_CHECK
                        ).forEach {
                            authVM.resetValue(it)
                        }
                    } else {
                        Toast.makeText(context, "빈칸을 입력 해주세요", Toast.LENGTH_SHORT).show()
                    }
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
fun ShowSignuB(){
    val navController = rememberNavController()
    val authVM : AuthVM = viewModel()
    SignupB(curNavController = navController, authVM = authVM)
}