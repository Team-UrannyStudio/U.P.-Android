package com.example.up.act.nav.graph

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.up.act.nav.Community
import com.example.up.act.nav.Get
import com.example.up.act.nav.Home
import com.example.up.act.nav.Profile
import com.example.up.act.nav.Rally
import com.example.up.act.post.CommunityPost
import com.example.up.act.post.GetPost
import com.example.up.act.post.RallyPost
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.vm.main.MainViewModel
import com.example.up.data.cls.nav.BottomNavItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavGraph(modifier : Modifier,
                 parentNavController: NavHostController,
                 navController: NavHostController,
                 mainVM : MainViewModel,
                 startDestination : String,
                 onViewChange : (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        // MainPage
        composable(BottomNavItem.Home.route){
            Home(
                modifier,
                navController,
                mainVM
            )
        }
        composable(BottomNavItem.Rally.route){
            Rally(
                modifier, navController,
                onAddClick = { onViewChange(it) }
            )
        }
        composable(BottomNavItem.Get.route){
            Get(
                modifier,
                navController,
                onAddClick = { onViewChange(it) }
            )
        }
        composable(BottomNavItem.Community.route){
            Community(
                modifier,
                navController,
                onAddClick = { onViewChange(it) }
            )
        }
        composable(BottomNavItem.Profile.route){
            Profile(
                modifier,
                navController
            )
        }

        // PostPage
        composable("RallyPost/{index}"){ backStackEntry ->
            val index =  backStackEntry.arguments?.getString("index")
            index?.let {
                val rallyPst = LstInfo.rallyLst[index.toInt()]
                RallyPost(pst = rallyPst,
                    modifier = modifier,
                    navController = navController,
                    mainVM = mainVM
                )
            }
        }

        composable("GetPost/{index}"){ backStackEntry ->
            val index =  backStackEntry.arguments?.getString("index")
            index?.let {
                val getPst = LstInfo.getLst[index.toInt()]
                GetPost(pst = getPst,
                    modifier = modifier,
                    navController = navController,
                    parentNavController = parentNavController,
                    mainVM = mainVM
                )
            }
        }

        composable("ComPost/{index}"){ backStackEntry ->
            val index =  backStackEntry.arguments?.getString("index")
            Log.d("ComPost", "NavGraph : $index")
            index?.let {
                val comPst = LstInfo.comPostLst[index.toInt()]
                CommunityPost(pst = comPst,
                    modifier = modifier,
                    navController = navController,
                    parentNavController = parentNavController,
                    mainVM = mainVM
                )
            }
        }
    }
}