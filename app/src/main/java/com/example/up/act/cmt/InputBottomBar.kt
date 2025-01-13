package com.example.up.act.cmt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.R
import com.example.up.act.itg.PlaceHolderTxt
import com.example.up.act.itg.textFieldDefaultsColor
import com.example.up.ui.theme.FontDarkGray
import com.example.up.ui.theme.FontGray
import kotlin.math.max

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBottomBar(
    value : String,
    onValueChange : (String) -> Unit,
    interactionSource: MutableInteractionSource =
        remember { MutableInteractionSource() }
){
    Row(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .wrapContentHeight()
        .heightIn(max = 180.dp)
        .drawBehind {
            drawLine(
                color = FontGray,
                start = Offset(0f, 0f), // 시작 좌표 (왼쪽 상단)
                end = Offset(size.width, 0f), // 끝 좌표 (오른쪽 상단)
                strokeWidth = 1.dp.toPx() // 선의 두께
            )
        },
    ) {
        Image(modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp, top = 16.dp)
            .size(28.dp)
            .background(Color.White)
            .align(Alignment.Bottom)
            .clip(shape = CircleShape)
            .border(1.dp, color = FontDarkGray, shape = CircleShape),
            imageVector = Icons.Default.Person,
            contentDescription = "Person"
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(start = 8.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
            .align(Alignment.Bottom)
        ) {
            BasicTextField(
                value = value ,
                onValueChange = onValueChange,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
                    .wrapContentHeight(),
                textStyle = TextStyle(
                    fontSize = (12).sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            ) {
                TextFieldDefaults.DecorationBox(
                    value = value,
                    colors = textFieldDefaultsColor(),
                    innerTextField = it,
                    enabled = true,
                    singleLine = false,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    placeholder = {
                        PlaceHolderTxt(
                            "댓글을 입력하세요...",
                            8,
                            FontWeight.Medium
                        )
                    },
                    contentPadding = PaddingValues(0.dp),
                )
            }
            HorizontalDivider(modifier = Modifier
                .fillMaxWidth(),
                color = FontDarkGray,
                thickness = 1.dp
            )
        }
        Image(modifier = Modifier
            .padding(end = 12.dp, bottom = 12.dp, top = 12.dp)
            .align(Alignment.Bottom)
            .size(36.dp)
            .background(Color.White),
            painter = painterResource(id = R.drawable.send_img),
            contentDescription = "Person"
        )
    }
}

@Preview(showBackground = false)
@Composable
fun ShowInputBottomBar(){
    InputBottomBar(value = "", onValueChange = {})
}