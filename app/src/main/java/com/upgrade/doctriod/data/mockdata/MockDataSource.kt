package com.upgrade.doctriod.data.mockdata

import com.upgrade.doctriod.models.Address
import com.upgrade.doctriod.models.Doctor
import com.upgrade.doctriod.data.DoctorDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockDataSource @Inject constructor() : DoctorDataSource {

    override fun listAll(success: (List<Doctor>) -> Unit, failure: () -> Unit) {
        success(getDoctors())
    }

    private fun getDoctors(): MutableList<Doctor> {
        val doctor1 = Doctor(
            "Linda Null",
            "Neurologista",
            Address("Rua das Flores", "31", "Bairro Sucesso", "Manaus-AM"),
            "data:image/jpeg;base64,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",
            4.5
        )
        val doctor2 = Doctor(
            "Thomas Cormen",
            "Cardiologista",
            Address("Avenida das Laranjeiras", "13", "Bairro Vitória", "Manaus-AM"),
            "data:image/jpeg;base64,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",
            4.5
        )
        val doctorsList = mutableListOf<Doctor>()
        doctorsList.add(doctor1)
        doctorsList.add(doctor2)
        doctorsList.add(doctor1)
        doctorsList.add(doctor2)
        doctorsList.add(doctor1)
        doctorsList.add(doctor2)
        doctorsList.add(doctor1)
        doctorsList.add(doctor2)
        doctorsList.add(doctor1)
        doctorsList.add(doctor2)
        doctorsList.add(doctor1)
        doctorsList.add(doctor2)
        return doctorsList
    }
}