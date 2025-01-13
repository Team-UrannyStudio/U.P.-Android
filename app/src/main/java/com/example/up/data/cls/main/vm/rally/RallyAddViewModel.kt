package com.example.up.data.cls.main.vm.rally

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RallyAddViewModel : ViewModel() {
    // 상태 객체를 하나만 만들고, 이를 수정하는 방식으로 메모리 사용 최적화
    private val _state = mutableStateOf(RallyAddData())
    val state: State<RallyAddData> = _state

    // 상태 속성들을 직접 수정하는 함수들
    fun updateTitle(newTitle: String) {
        _state.value = _state.value.copy(title = newTitle)
    }

    fun updateMaster(newMaster: String) {
        _state.value = _state.value.copy(master = newMaster)
    }

    fun updateApply(newApply: String) {
        _state.value = _state.value.copy(apply = newApply)
    }

    fun updateCost(newCost: String) {
        _state.value = _state.value.copy(cost = newCost)
    }

    fun updatePrice(newPrice: String) {
        _state.value = _state.value.copy(price = newPrice)
    }

    fun updateHomePageLink(newLink: String) {
        _state.value = _state.value.copy(homePageLink = newLink)
    }

    fun updateApplyLink(newLink: String) {
        _state.value = _state.value.copy(applyLink = newLink)
    }

    fun updateContact(newContact: String) {
        _state.value = _state.value.copy(contact = newContact)
    }

    fun updateEtc(newEtc: String) {
        _state.value = _state.value.copy(etc = newEtc)
    }

    fun updateSelectCtgIndex(newIndex: Int) {
        _state.value = _state.value.copy(selectCtgIndex = newIndex)
    }

    fun updateSelectPlaceIndex(newIndex: Int) {
        _state.value = _state.value.copy(selectPlaceIndex = newIndex)
    }

    fun updateSelectPartIndex(newIndex: Int) {
        _state.value = _state.value.copy(selectPartIndex = newIndex)
    }

    fun updateSelectStartDate(newDate: String) {
        _state.value = _state.value.copy(selectStartDate = newDate)
    }

    fun updateSelectEndDate(newDate: String) {
        _state.value = _state.value.copy(selectEndDate = newDate)
    }

    fun updateShowStartCalendar(newBool : Boolean){
        _state.value = _state.value.copy(showStartCalendar = newBool)
    }

    fun updateShowEndCalendar(newBool : Boolean){
        _state.value = _state.value.copy(showEndCalendar = newBool)
    }
}