package com.upgrade.doctriod.di

import com.upgrade.doctriod.data.DoctorRepository
import com.upgrade.doctriod.viewmodel.DoctorViewModel
import dagger.Module
import dagger.Provides

@Module
class DoctorViewModelModule {

    @Provides
    @ActivityScope
    fun provideDoctorViewModel(
        doctorRepository: DoctorRepository
    ) : DoctorViewModel {
        return DoctorViewModel(doctorRepository)
    }
}