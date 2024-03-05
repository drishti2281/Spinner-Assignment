package com.example.spinnerassignment

data class SpinnerModel(
        var id : Int? = 0,
        var name : String? = "",
        var address : String? = "",) {
     override fun toString(): String {
        return "$name"
    }
}
