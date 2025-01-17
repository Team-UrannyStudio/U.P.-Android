package com.example.up.data.cls.main.vm.auth

import androidx.lifecycle.ViewModel
import com.example.up.data.cls.main.vm.auth.AuthValue.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class AuthValue{ NAME, TEL, PTP, EMAIL,ID, PW, PW_CHECK }

class AuthVM : ViewModel() {
    private val _name = MutableStateFlow<String>("")
    val name : StateFlow<String> get() = _name

    private val _tel = MutableStateFlow<String>("")
    val tel : StateFlow<String> get() = _tel

    private val _ptp = MutableStateFlow<String>("")
    val ptp : StateFlow<String> get() = _ptp

    private val _email = MutableStateFlow<String>("")
    val email : StateFlow<String> get() = _email

    private val _id = MutableStateFlow<String>("")
    val id : StateFlow<String> get() = _id

    private val _pw = MutableStateFlow<String>("")
    val pw : StateFlow<String> get() = _pw

    private val _pwCheck = MutableStateFlow<String>("")
    val pwCheck : StateFlow<String> get() = _pwCheck

    fun updateValue(enumValue : AuthValue, newValue : String){
        when(enumValue){
            NAME -> {_name.value = newValue}
            TEL -> {_tel.value = newValue}
            PTP -> {_ptp.value = newValue}
            EMAIL -> {_email.value = newValue}
            ID -> {_id.value = newValue}
            PW -> {_pw.value = newValue}
            PW_CHECK -> {_pwCheck.value = newValue}
        }
    }

    fun resetValue(enumValue : AuthValue){
        when(enumValue){
            NAME -> {_name.value = ""}
            TEL -> {_tel.value = ""}
            PTP -> {_ptp.value = ""}
            EMAIL -> {_email.value = ""}
            ID -> {_id.value = ""}
            PW -> {_pw.value = ""}
            PW_CHECK -> {_pwCheck.value = ""}
        }
    }

}