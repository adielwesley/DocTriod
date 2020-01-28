package com.upgrade.doctriod.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubcomponentModule::class, DataModule::class, AppModule::class])
interface ApplicationComponent {

    fun doctorComponent(): DoctorComponent.Factory

}