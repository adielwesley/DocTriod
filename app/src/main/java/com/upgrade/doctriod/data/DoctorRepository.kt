package com.upgrade.doctriod.data

import com.upgrade.doctriod.models.Doctor

class DoctorRepository(private var doctorDataSource : DoctorDataSource) :
    DoctorDataSource {

    override fun listAll(success: (List<Doctor>) -> Unit, failure: () -> Unit) {
        doctorDataSource.listAll(success, failure)
    }

}