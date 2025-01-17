package com.example.up.act.itg

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.act.bar.TopBar
import com.example.up.data.LstInfo
import com.example.up.data.cls.cmt.Cmt
import com.example.up.data.cls.main.ComPst
import com.example.up.data.cls.main.GetPst
import com.example.up.data.cls.main.PostBasic
import com.example.up.data.cls.main.PostData
import com.example.up.data.cls.main.PostElementData
import com.example.up.data.cls.main.vm.main.MainViewModel
import com.example.up.item.CategoryItem
import com.example.up.item.CmtViewItem
import com.example.up.item.PostCmtItem
import com.example.up.item.PostItem
import com.example.up.ui.theme.FontDarkGray
import com.example.up.ui.theme.UPTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostItgView (modifier : Modifier,
                 postData: PostData,
                 navController : NavHostController,
                 parentNavController : NavHostController = rememberNavController(),
                 mainVM : MainViewModel = MainViewModel()
) {
    val state = rememberScrollState()
    val elementDataLst = postData.toDataLst()
    val data = postData.toData()

    Column(modifier = modifier
        .verticalScroll(state)
        .fillMaxSize()
    ) {
        TopBar(1,
            navController
        )
        if(data.communityBody.isNullOrEmpty()){
            RNGPostItgView(
                postData = postData,
                parentNavController = parentNavController,
                elementDataLst = elementDataLst
            )
        } else {
            val comPst = if (postData is ComPst){
                postData.toComPst()
            } else{
                throw IllegalArgumentException("postData는 ComPst 타입이어야 합니다.")
            }
            ComPostItgView(
                data = data,
                pst = comPst,
                elementDataLst = elementDataLst,
                parentNavController = parentNavController,
                onClick = {
                    val nxtComPst = LstInfo.comPostLst.indexOf(it)
                    navController.navigate("ComPost/${nxtComPst}"){
                        restoreState = true
                    }
                }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ComPostItgView(
    data : PostBasic,
    pst : ComPst,
    parentNavController : NavHostController,
    elementDataLst : List<PostElementData>,
    onClick : (ComPst) -> Unit
){
    val cmtCount = pst.cmtLst.size
    val curIndex = LstInfo.comPostLst.indexOf(pst)
    val maxIndex = LstInfo.comPostLst.size-1

    val otherPstLst = otherPstLst(
        pstLst = LstInfo.comPostLst,
        curIndex = curIndex,
        maxIndex = maxIndex
    )

    PostHeader(data = data, community = true)

    Box(modifier = Modifier
        .padding(top = 20.dp, start = 28.dp, end = 28.dp)
        .fillMaxWidth()
        .background(Color.White)
        .clip(RoundedCornerShape(4.dp))
    ){
        Text(modifier = Modifier
            .align(Alignment.Center),
            text = "사진이당"
        )
    }
    Spacer(modifier = Modifier
        .height(16.dp)
    )
    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp),
        text = data.communityBody!!,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Black
    )
    HorizontalDivider(modifier = Modifier
        .padding(top = 24.dp, start = 24.dp, end = 24.dp)
        .fillMaxWidth(),
        color = FontDarkGray,
        thickness = 1.dp
    )
    Row(modifier = Modifier
        .padding(top = 12.dp, start = 24.dp, end = 24.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier
            .padding(start = 4.dp),
            text = if(cmtCount != 0)"댓글 ${cmtCount}개" else "댓글",
            fontSize = 20.sp,
            color = Color.Black
        )
        Icon(modifier = Modifier
            .padding(end = 4.dp),
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Fav"
        )
    }
    if(pst.cmtLst.size > 0){
        PostCmtItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 24.dp, end = 24.dp),
            imageUrl = pst.cmtLst[0].imgUrl,
            body = pst.cmtLst[0].body
        ){
            parentNavController.navigate("CMT/C/${pst.id}")
        }
    } else{
        PostCmtItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 24.dp, end = 24.dp),
            imageUrl = "defalut",
            body = "댓글이 없습니다,",
            showImg = false
        ){
            parentNavController.navigate("CMT/C/${pst.id}")
        }
    }
    Text(modifier = Modifier
        .padding(start = 28.dp, top = 28.dp),
        text = "다른글",
        fontSize = 20.sp,
        color = Color.Black
    )
    Column(modifier = Modifier
        .padding(top = 8.dp, start = 24.dp, end =24.dp, bottom = 18.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        otherPstLst.forEachIndexed { index, comPst ->
            PostItem(title = comPst.title,
                category = comPst.category,
                dateTime = comPst.createTime,
                user = comPst.master,
                cmtLst = comPst.cmtLst,
                isCurrent = pst.id == comPst.id
            ) {
                onClick(comPst)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RNGPostItgView(
    postData : PostData,
    parentNavController: NavHostController,
    elementDataLst : List<PostElementData>
){
    val data = postData.toData()

    Box(modifier = Modifier
        .padding(top = 24.dp, start = 24.dp, end = 24.dp)
        .fillMaxWidth()
        .height(509.dp)
        .background(Color.White)
        .clip(RoundedCornerShape(4.dp))
    ){
        Text(modifier = Modifier
            .align(Alignment.Center),
            text = "사진이당"
        )
    }
    Row(modifier = Modifier
        .padding(top = 16.dp, start = 24.dp, end = 24.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CategoryItem(
            text = data.category,
            isClick = false
        ) { item ->
            Log.d("Click", "Tag")
        }
        Icon(modifier = Modifier
            .padding(end = 4.dp),
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Fav"
        )
    }

    PostHeader(data = data)

    Spacer(modifier = Modifier
        .height(24.dp)
    )
    elementDataLst.forEach { i ->
        PostElement(
            i,
            parentNavController
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(28.dp)
        )
    }

    if(postData is GetPst){
        val cmtLst = postData.cmtLst
        Text(modifier = Modifier
            .padding(start = 28.dp),
            text = "댓글${if (!(cmtLst.size == 0)) " ${cmtLst.size}개" else ""}",
            fontSize = 20.sp,
            color = Color.Black
        )
        if(cmtLst.size > 0){
            PostCmtItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 28.dp, end = 28.dp, bottom = 20.dp),
                imageUrl = cmtLst[0].imgUrl,
                body = cmtLst[0].body
            ){
                parentNavController.navigate("CMT/G/${postData.id}")
            }
        } else{
            PostCmtItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 28.dp, end = 28.dp, bottom = 20.dp),
                imageUrl = "defalut",
                body = "댓글이 없습니다,",
                showImg = false
            ){
                parentNavController.navigate("CMT/G/${postData.id}")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDayOfWeek(localDateTime: LocalDateTime) : String {
    return localDateTime.format(
        DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE HH:mm", Locale.KOREAN)
    )
}

@Composable
fun HyperLinkText(link : String){
    val context = LocalContext.current

    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(
            tag = "URL",
            annotation = link
        )
        withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
            append(link)
        }
        pop()
    }

    ClickableText(modifier = Modifier,
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    // 브라우저 열기
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                    context.startActivity(intent)
                }
        },
        style = TextStyle()
    )
}

@Composable
fun PostElement(element : PostElementData,
                parentNavController: NavHostController
){
    Column(modifier = Modifier
        .padding(start = 28.dp, end = 28.dp)
    ) {
        if(element.checkTitle){
            Text(modifier = Modifier,
                text = element.title,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
            )
        }
        when{
            element.hyper -> {
                HyperLinkText(link = element.body)
            }
            else -> {
                Text(modifier = Modifier,
                    text = element.body,
                    color = FontDarkGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostHeader(data: PostBasic, community : Boolean = false){
    if(community){
        Text(modifier = Modifier
            .padding(top = 32.dp, start = 24.dp, end = 24.dp),
            text = "[${data.category}] "+ data.title,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    } else{
        Text(modifier = Modifier
            .padding(top = 16.dp, start = 24.dp, end = 24.dp),
            text = data.title,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
    HorizontalDivider(modifier = Modifier
        .padding(top = 8.dp, start = 24.dp, end = 24.dp)
        .fillMaxWidth(),
        color = FontDarkGray,
        thickness = 1.dp
    )
    Row(modifier = Modifier
        .padding(start = 28.dp, top = 4.dp, end = 28.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(modifier = Modifier,
            text = data.master,
            color = Color.DarkGray,
            fontSize = 12.sp
        )
        Text(modifier = Modifier,
            text = getDayOfWeek(data.createTime),
            color = Color.DarkGray,
            fontSize = 12.sp
        )
    }
}

fun otherPstLst(pstLst : List<ComPst>,
                curIndex : Int,
                maxIndex : Int
) : List<ComPst> {
    val otherPstLst = arrayListOf<ComPst>()

    if(curIndex > 0){
        otherPstLst.add(pstLst[curIndex-1])
    }

    otherPstLst.add(pstLst[curIndex])

    if(curIndex < maxIndex){
        otherPstLst.add(pstLst[curIndex+1])
    }

    return otherPstLst
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowPostItemView(){
    val postData = LstInfo.comPostLst.firstOrNull() ?: return
    UPTheme {
        PostItgView(modifier = Modifier,
            postData,
            rememberNavController()
        )
    }
}
