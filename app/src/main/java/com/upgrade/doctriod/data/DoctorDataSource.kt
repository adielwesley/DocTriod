package com.upgrade.doctriod.data

import com.upgrade.doctriod.models.Doctor

interface DoctorDataSource {

    fun listAll(success : (List<Doctor>) -> Unit, failure : () -> Unit)
}