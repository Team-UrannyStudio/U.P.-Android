package com.example.up.act.nav.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.up.act.auth.Login
import com.example.up.act.auth.SignupA
import com.example.up.act.auth.SignupB
import com.example.up.act.auth.Start
import com.example.up.data.cls.main.vm.auth.AuthVM

@Composable
fun AuthNavGraph(
    modifier : Modifier,
    parentNavController : NavHostController
) {
    val navController = rememberNavController()
    val authVM : AuthVM = viewModel()

    NavHost(
        navController = navController,
        startDestination = "START",
    ){
        composable("START"){
            Start(modifier,
                navController,
                authVM
            )
        }
        composable("LOGIN"){
            Login(
                modifier,
                parentNavController,
                authVM
            )
        }
        composable("SIGNUPA"){
            SignupA(modifier,
                navController,
                authVM
            )
        }
        composable("SIGNUPB"){
            SignupB(modifier,
                navController,
                authVM
            )
        }
    }
}