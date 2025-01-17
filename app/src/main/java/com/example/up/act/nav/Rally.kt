package com.example.up.act.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.itg.PageView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Rally(modifier : Modifier,
          navController : NavHostController,
          onAddClick : (String) -> Unit = {}
){
    PageView(modifier,
        'R',
        navController,
        onClick = { navController.navigate(it) },
        onAddClick = {onAddClick(it)}
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowRally(){
    val navController = rememberNavController()
    Rally(Modifier, navController)
}