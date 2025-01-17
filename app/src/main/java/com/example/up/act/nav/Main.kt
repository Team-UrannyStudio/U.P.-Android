package com.example.up.act.nav

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.nav.graph.MainNavGraph
import com.example.up.data.cls.main.vm.main.MainViewModel
import com.example.up.data.cls.nav.BottomNavItem
import com.example.up.ui.theme.BtnGray
import com.example.up.ui.theme.FontGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Main(parentNavController: NavHostController){

    val mainVM : MainViewModel = viewModel()

    val navController = rememberNavController()

    val selectIndex by mainVM.index.collectAsState()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Rally,
        BottomNavItem.Get,
        BottomNavItem.Community,
        BottomNavItem.Profile
    )

    LaunchedEffect(selectIndex) {
        navController.navigate(items[selectIndex].route) {
            popUpTo(navController.graph.startDestinationId) { // 유지
                saveState = true // 상태 저장
            }
            launchSingleTop = true // 중복 방지
            restoreState = true // 상태 복원
        }
    }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            val currentRoute = destination.route
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .drawBehind {
                        drawLine(
                            color = FontGray,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 1.dp.toPx()
                        )
                    },
                backgroundColor = Color.White,
                contentColor = BtnGray
            ) {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = index == selectIndex,
                        onClick = {
                            mainVM.changeIndex(index)
                        },
                        icon = {
                            Icon( modifier = Modifier
                                .height(36.dp),
                                painter = painterResource(id = item.icon),
                                contentDescription = item.route,
                                tint = if (index == selectIndex) Color.Black else BtnGray
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        MainNavGraph(modifier = Modifier
            .padding(innerPadding),
            navController = navController,
            parentNavController = parentNavController,
            mainVM = mainVM,
            startDestination = items[selectIndex].route,
            onViewChange = {
                parentNavController.navigate(it){
                    popUpTo("MAIN") {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}