package com.example.up.data.cls.main.vm.rally

import androidx.lifecycle.ViewModel
import com.example.up.data.cls.main.vm.rally.RallyAddEnum.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class RallyAddEnum{
    TITLE,
    MASTER,
    APPLY,
    COST,
    PRICE,
    HOME_LINK,
    APPLY_LINK,
    CONTACT,
    ETC,
    CTG,
    PLACE,
    PART,
    START_DATE,
    END_DATE,
    SHOW_START,
    SHOW_END
}

class RallyAddVM : ViewModel() {
    private val _state = MutableStateFlow(RallyAddData())
    val state: StateFlow<RallyAddData> get() = _state

    fun updateState(enum: RallyAddEnum, content: Any) {
        _state.value = when (enum) {
            TITLE -> _state.value.copy(title = content as String)
            MASTER -> _state.value.copy(master = content as String)
            APPLY -> _state.value.copy(apply = content as String)
            COST -> _state.value.copy(cost = content as String)
            PRICE -> _state.value.copy(price = content as String)
            HOME_LINK -> _state.value.copy(homeLink = content as String)
            APPLY_LINK -> _state.value.copy(applyLink = content as String)
            CONTACT -> _state.value.copy(contact = content as String)
            ETC -> _state.value.copy(etc = content as String)
            CTG -> _state.value.copy(ctg = content as Int)
            PLACE -> _state.value.copy(place = content as Int)
            PART -> _state.value.copy(part = content as Int)
            START_DATE -> _state.value.copy(startDate = content as String)
            END_DATE -> _state.value.copy(endDate = content as String)
            SHOW_START -> _state.value.copy(showStart = content as Boolean)
            SHOW_END -> _state.value.copy(showEnd = content as Boolean)
        }
    }

}