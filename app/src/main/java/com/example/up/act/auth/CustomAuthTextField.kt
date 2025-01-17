package com.example.up.act.auth

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.act.itg.textFieldDefaultsColor
import com.example.up.ui.theme.FontDarkGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAuthTextField(
    title : String,
    value : String,
    onValueChange : (String) -> Unit,
    interactionSource: MutableInteractionSource =
        remember { MutableInteractionSource() }
){
    Text( modifier = Modifier
        .padding(top = 64.dp, start = 10.dp, end = 8.dp),
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = FontDarkGray
    )
    BasicTextField(
        value = value ,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(4.dp)),
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        ),
        visualTransformation = if(title == "pw") PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true
    ) {
        TextFieldDefaults.DecorationBox(
            value = value,
            colors = textFieldDefaultsColor(),
            innerTextField = it,
            enabled = true,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            contentPadding = PaddingValues(0.dp)
        )
    }
    HorizontalDivider(modifier = Modifier
        .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        .fillMaxWidth(),
        color = FontDarkGray,
        thickness = 1.dp
    )
}