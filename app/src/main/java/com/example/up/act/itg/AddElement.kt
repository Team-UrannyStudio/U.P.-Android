package com.example.up.act.itg

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.up.data.cls.etc.Ctg
import com.example.up.item.CategoryItem
import com.example.up.ui.theme.FontDarkGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddElement(
    title : String,
    onValueChange : (Any) -> Unit,
    modifier : Modifier,

    value : String? = null,
    holder : String? = null,

    selectIndex: Int? = null,
    categoryLst : List<Ctg>? = null,

    startDate : String? = null,
    endDate : String? = null

){
    Text(modifier = Modifier
        .padding(top = 28.dp, start = 28.dp),
        text = title,
        fontSize = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight.Medium
    )
    if(categoryLst != null && selectIndex != null){
        ItemGridView(categoryLst = categoryLst, selectIndex) {
            onValueChange(it)
        }

    } else if(value != null && holder != null){
        CustomTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            holder = holder,
            addDp = 4,
            minusFontSize = 4,
            fontWeight = FontWeight.Medium,
            modifier = modifier
        )
    } else if(startDate != null && endDate != null){
        Row(modifier = Modifier
            .padding(start = 28.dp, end = 28.dp, top = 4.dp)
        ){
            DateSelectBox(
                selectDate = startDate,
                nullTxt = "2025-01-01"
            ) {
                onValueChange(true)
            }
            Text( modifier = Modifier
                .padding(horizontal = 4.dp),
                text = "~",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = FontDarkGray
            )
            DateSelectBox(
                selectDate = endDate,
                nullTxt = "2025-12-31"
            ) {
                onValueChange(false)
            }
        }
    }
}

@Composable
fun DateSelectBox(
    selectDate : String,
    nullTxt : String,
    onBoxClick : () -> Unit
){
    Row(modifier = Modifier
        .background(Color.White, shape = RoundedCornerShape(4.dp))
        .padding(horizontal = 6.dp, vertical = 4.dp)
        .clickable { onBoxClick() },
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon( modifier = Modifier
            .size(20.dp),
            imageVector = Icons.Default.DateRange,
            contentDescription = "Date",
            tint = Color.Black
        )
        Text(modifier = Modifier
            .padding(end = 4.dp),
            text = if(selectDate.isEmpty()) nullTxt else selectDate,
            color = if(selectDate.isEmpty()) FontDarkGray else Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemGridView(
    categoryLst : List<Ctg>,
    selectIndex : Int,
    onTagClick : (Int) -> Unit
){
    FlowRow(modifier = Modifier
        .padding(top = 8.dp, start = 28.dp, end = 28.dp)
        .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categoryLst.forEachIndexed { index, item ->
            if(index != 0){
                CategoryItem(
                    text = item.title,
                    textColor = if(selectIndex == index) Color.White else Color.Black,
                    backColor = if(selectIndex == index) Color.Black else Color.White
                ) { tag ->
                    onTagClick(categoryLst.indexOfFirst { it.title == tag })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value : String,
                    onValueChange : (String) -> Unit,
                    holder : String,
                    modifier : Modifier,
                    interactionSource: MutableInteractionSource =
                        remember { MutableInteractionSource() },
                    addDp : Int = 0,
                    fontWeight: FontWeight = FontWeight.Medium,
                    topAddDp : Int = 0,
                    minusFontSize : Int = 0
){
    BasicTextField(
        value = value ,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(top = (4+topAddDp).dp, start = (24 + addDp).dp, end = (24 + addDp).dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(4.dp)),
        textStyle = TextStyle(
            fontSize = (20-minusFontSize).sp,
            fontWeight = fontWeight,
            color = Color.Black
        ),
        singleLine = false
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
                    holder,
                    minusFontSize,
                    fontWeight
                )
            },
            contentPadding = PaddingValues(0.dp),
        )
    }
}

@Composable
fun textFieldDefaultsColor() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    errorContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    errorIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    disabledTextColor = Color.Black,
    focusedTextColor = Color.Black,
    unfocusedTextColor = Color.Black,
    errorTextColor = Color.Black,
    focusedPlaceholderColor = FontDarkGray,
    unfocusedPlaceholderColor = FontDarkGray,
    disabledPlaceholderColor = FontDarkGray,
    errorPlaceholderColor = FontDarkGray
)


@Composable
fun PlaceHolderTxt(text : String,
                   addDp: Int = 0,
                   fontWeight : FontWeight
){
    Text(modifier = Modifier,
        text = text,
        fontSize = (20-addDp).sp,
        fontWeight = fontWeight
    )
}
