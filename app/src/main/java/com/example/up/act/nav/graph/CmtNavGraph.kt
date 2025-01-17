package com.example.up.act.nav.graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.up.act.cmt.CmtView
import com.example.up.act.cmt.InCmtView
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.vm.cmt.CmtVM

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CmtNavGraph( type : String,
                 index : Int,
                 modifier : Modifier,
                 parentNavController: NavHostController,
){
    val navController = rememberNavController()
    val cmtVM : CmtVM = viewModel()

    val pst = if(type == "G") LstInfo.getLst[index] else LstInfo.comPostLst[index]

    var cmtLst by remember{ mutableStateOf(pst.toCmtLst()) }

    NavHost(navController = navController,
        startDestination =  "CMT",
    ) {
        composable("CMT"){
            CmtView(
                navController = navController,
                cmtLst = cmtLst,
                cmtVM = cmtVM,
                parentNavController = parentNavController
            )
        }
        composable("INCMT/{index}"){ backStackEntry ->
            val parentIndex = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
            InCmtView(
                parent = cmtLst[parentIndex],
                navController = navController
            )
        }
    }
}
