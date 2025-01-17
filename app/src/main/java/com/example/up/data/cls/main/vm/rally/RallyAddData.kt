package com.example.up.data.cls.main.vm.rally

data class RallyAddData(
    var title : String = "",
    var master : String = "",
    var apply : String = "",
    var cost : String = "",
    var price : String = "",
    var homeLink : String = "",
    var applyLink : String = "",
    var contact : String = "",
    var etc : String = "",

    var ctg : Int = 1,
    var place : Int = 1,
    var part : Int = 1,

    var startDate : String = "",
    var endDate : String = "",

    var showStart : Boolean = false,
    var showEnd : Boolean = false
)
