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
fun Get(modifier : Modifier,
        navController : NavHostController,
        onAddClick : (String) -> Unit = {}
){
    PageView(modifier,
        'G',
        navController,
        onClick = {
            navController.navigate(it) {
                popUpTo("MAIN") {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            } },
        onAddClick = {onAddClick(it)}
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowGet(){
    val navController = rememberNavController()
    Get(modifier = Modifier, navController)
}