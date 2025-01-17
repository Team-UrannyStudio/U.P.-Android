package com.example.up.data.cls.main.vm.cmt

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.up.data.cls.main.GetPst
import com.example.up.data.cls.nav.BottomNavItem

class CmtVM : ViewModel() {
    private val getMap = mutableMapOf<Int ,GetPst>()
}