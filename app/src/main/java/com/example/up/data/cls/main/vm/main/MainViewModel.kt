package com.example.up.data.cls.main.vm.main

import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _index = MutableStateFlow<Int>(0)
    val index : StateFlow<Int> get() = _index

    fun changeIndex(newIndex : Int){
        _index.value = newIndex
        Log.d("index", "newIndex : ${_index.value}")
    }
}