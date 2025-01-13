package com.example.up.act.post

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.up.act.itg.PostItgView
import com.example.up.data.LstInfo
import com.example.up.data.cls.main.GetPst

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GetPost(
    modifier : Modifier,
    pst : GetPst
){
    PostItgView(
        modifier = modifier,
        postData = pst
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowGetPost(){
    GetPost(modifier = Modifier, LstInfo.getLst[0])
}