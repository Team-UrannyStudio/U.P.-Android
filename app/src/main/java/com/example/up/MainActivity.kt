package com.example.up

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.up.act.add.CommunityAddView
import com.example.up.act.add.GetAddView
import com.example.up.act.add.RallyAddView
import com.example.up.act.auth.Auth
import com.example.up.act.cmt.Cmt
import com.example.up.act.nav.Main
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.vm.cmt.CmtVM
import com.example.up.ui.theme.UPTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val parentNavController = rememberNavController()
            val cmtVM : CmtVM = viewModel()

            UPTheme {
                NavHost(
                    navController = parentNavController,
                    startDestination = "AUTH"
                ) {
                    composable("AUTH"){
                        Auth(parentNavController)
                    }
                    composable("MAIN"){
                        Main(parentNavController)
                    }
                    composable("ADD/{where}"){ backStackEntry ->
                        val where =  backStackEntry.arguments?.getString("where")
                        where?.let {
                            when(where){
                                "R"-> RallyAddView(parentNavController)
                                "G" -> GetAddView(parentNavController)
                                "C" -> CommunityAddView(parentNavController)
                            }
                        }
                    }
                    composable("CMT/{type}/{id}"){ backStackEntry ->
                        val type = backStackEntry.arguments?.getString("type") ?: "G"
                        val id = backStackEntry.arguments?.getString("id")?.toLong() ?: 1L
                        val index = if(type == "G") {
                            LstInfo.getLst.indexOfFirst { it.id == id }
                        } else {
                            LstInfo.comPostLst.indexOfFirst { it.id == id }
                        }

                        Cmt(
                            type,
                            index,
                            parentNavController
                        )
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UPTheme {
        Main(rememberNavController())
    }
}