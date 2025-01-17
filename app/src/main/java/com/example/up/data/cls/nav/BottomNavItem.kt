package com.example.up.data.cls.nav

import com.example.up.R

sealed class BottomNavItem(
    val route : String, val icon : Int
){
    data object Home : BottomNavItem("HOME", R.drawable.home)
    data object Rally : BottomNavItem("RALLY", R.drawable.rally)
    data object Get : BottomNavItem("GET", R.drawable.get)
    data object Community : BottomNavItem("COMMUNITY", R.drawable.community)
    data object Profile : BottomNavItem("PROFILE", R.drawable.btm_profile)
}