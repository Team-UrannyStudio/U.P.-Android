package com.example.up.item

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.ui.theme.UPTheme

@Composable
fun CategoryItem(
    text : String,
    isClick : Boolean = true,
    backColor : Color = Color.White,
    textColor : Color = Color.Black,
    onItemClick : (String) -> Unit,
    ){
    Box(modifier = if(isClick){ Modifier
        .clip(RoundedCornerShape(12.dp))
        .background(backColor)
        .clickable { onItemClick(text) }
    } else {
        Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backColor)
    }
    ){
        Text(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
            text = text,
            fontSize = 14.sp,
            color = textColor
        )
    }
}

@Preview(showBackground = false)
@Composable
fun CategoryItemPreView() {
    UPTheme {
        CategoryItem(text = "전체"){text->
            Log.d("Click", "category item Click")
        }
    }
}