package com.upgrade.doctriod.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.upgrade.doctriod.models.Doctor
import com.upgrade.doctriod.data.DoctorDataSource
import com.upgrade.doctriod.di.ActivityScope
import javax.inject.Inject

class DoctorViewModel(val repository: DoctorDataSource) : ViewModel() {

    val doctors = ObservableArrayList<Doctor>()
    val loading = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loading.set(true)
        message.set("")

        repository.listAll(
            { items ->
                loading.set(false)
                message.set("")
                doctors.clear()
                doctors.addAll(items)
            },
            {
                loading.set(false)
                message.set("Falha ao carregar lista.")
            })
    }
}