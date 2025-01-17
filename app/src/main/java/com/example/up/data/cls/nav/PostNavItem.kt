package com.example.up.data.cls.nav

sealed class PostNavItem(
    val route: String
){
    data object RPst : PostNavItem("RPst")
    data object GPst : PostNavItem("GPst")
    data object CPst : PostNavItem("CPst")
}