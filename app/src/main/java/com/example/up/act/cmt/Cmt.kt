package com.example.up.act.cmt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.up.act.bar.InputBottomBar
import com.example.up.act.nav.graph.CmtNavGraph
import com.example.up.data.cls.cmt.Cmt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Cmt(type : String,
        index : Int,
        parentNavController : NavHostController
){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        CmtNavGraph(modifier = Modifier
            .fillMaxSize()
            .padding(it),
            parentNavController = parentNavController,
            type = type,
            index = index
        )
    }
}