package com.upgrade.doctriod.di

import com.upgrade.doctriod.features.listdoctors.DoctorListActivity
import com.upgrade.doctriod.features.listdoctors.ListDoctorFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DoctorViewModelModule::class])
interface DoctorComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DoctorComponent
    }

    fun inject(doctorListActivity: DoctorListActivity)
    fun inject(listDoctorFragment: ListDoctorFragment)
}