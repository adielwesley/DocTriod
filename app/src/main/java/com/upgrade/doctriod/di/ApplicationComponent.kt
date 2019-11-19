package com.upgrade.doctriod.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubcomponentModule::class, DataModule::class])
interface ApplicationComponent {

    fun doctorComponent(): DoctorComponent.Factory

}