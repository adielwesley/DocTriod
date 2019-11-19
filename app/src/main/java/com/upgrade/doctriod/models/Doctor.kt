package com.upgrade.doctriod.models

data class Doctor (val name : String,
                   var specialization : String,
                   val address : Address,
                   val photoUrl : String,
                   val rating : Double) {

    companion object {

        @JvmStatic
        fun getDistance() : String {
            return "2.1 km"
        }
    }
}