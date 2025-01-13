package com.example.up.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.ui.theme.FontDarkGray
import com.example.up.ui.theme.UPTheme

@Composable
fun PostCmtItem(modifier: Modifier, imageUrl : String, body : String){
    Box(modifier = Modifier
        .background(Color.White, shape = RoundedCornerShape(12.dp))
        .fillMaxWidth()
        .height(56.dp),
        contentAlignment = Alignment.Center
    ){
        Row(modifier = Modifier
            .padding(horizontal = 12.dp)
        ) {
            Image(modifier = Modifier
                .size(28.dp)
                .background(Color.White)
                .clip(shape = CircleShape)
                .border(1.dp, color = FontDarkGray, shape = CircleShape),
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
            Text(modifier = Modifier
                .padding(start = 8.dp),
                text = body,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ShowPostCmtItem(){
    UPTheme {
        PostCmtItem(Modifier, "url", "머롱모녀ㅑ푸ㅠ됴ㅑㅕ교ㅠ챠ㅕㄷㅈ무쳐조뱌풎댜ㅕㅐ펴쇼ㅐㅑㅠㄷ벼ㅑ펴ㅑ대쥬펴ㅑㅗ")
    }
}