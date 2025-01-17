package com.example.up.act.post

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.itg.PostItgView
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.RallyPst
import com.example.up.data.cls.main.vm.main.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RallyPost(
    modifier : Modifier = Modifier,
    pst : RallyPst,
    navController: NavHostController,
    mainVM : MainViewModel = MainViewModel()
){
    PostItgView(
        modifier = modifier,
        postData = pst,
        navController = navController,
        mainVM = mainVM
    )
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowRallyPost(){
    RallyPost(Modifier, LstInfo.rallyLst[0], rememberNavController())
}