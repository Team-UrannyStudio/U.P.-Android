package com.example.up.act.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.up.act.nav.graph.AuthNavGraph

@Composable
fun Auth(parentNavController : NavHostController){
    Scaffold(modifier = Modifier
        .fillMaxSize()
    ) {
        AuthNavGraph(modifier = Modifier.padding(it),
            parentNavController = parentNavController
        )
    }
}