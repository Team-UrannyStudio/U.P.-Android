package com.example.up.data.cls.main.vm.rally

data class RallyAddData(
    var title : String = "",
    var master : String = "",
    var apply : String = "",
    var cost : String = "",
    var price : String = "",
    var homePageLink : String = "",
    var applyLink : String = "",
    var contact : String = "",
    var etc : String = "",

    var selectCtgIndex : Int = 1,
    var selectPlaceIndex : Int = 1,
    var selectPartIndex : Int = 1,

    var selectStartDate : String = "",
    var selectEndDate : String = "",

    var showStartCalendar : Boolean = false,
    var showEndCalendar : Boolean = false
)
