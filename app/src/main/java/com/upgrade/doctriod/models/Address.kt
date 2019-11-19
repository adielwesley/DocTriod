package com.upgrade.doctriod.models

data class Address (val street : String,
                    val number : String,
                    val neighborhood : String,
                    val city : String) {

    override fun toString(): String {
        return "${street}, ${number}, ${neighborhood} - ${city}"
    }
}