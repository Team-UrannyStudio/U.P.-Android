package com.example.up.act.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.up.act.itg.PageView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Get(modifier : Modifier){
    PageView(modifier, 'G')
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowGet(){
    Get(modifier = Modifier)
}