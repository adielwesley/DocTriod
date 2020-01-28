package com.upgrade.doctriod.di

import com.upgrade.doctriod.data.DoctorRepository
import com.upgrade.doctriod.data.mockdata.MockDataSource
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDoctorRepository(
        mockDataSource: MockDataSource) : DoctorRepository {
        return DoctorRepository(mockDataSource)
    }

}