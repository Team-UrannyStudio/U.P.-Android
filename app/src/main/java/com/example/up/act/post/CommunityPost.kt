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
import com.example.up.data.cls.main.ComPst

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CommunityPost(
    modifier : Modifier,
    pst : ComPst
){
    PostItgView(
        modifier = modifier,
        postData = pst
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowCommunityPost(){
    CommunityPost(modifier = Modifier, pst = LstInfo.comPostLst[0])
}