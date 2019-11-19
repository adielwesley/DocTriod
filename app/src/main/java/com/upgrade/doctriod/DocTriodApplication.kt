package com.upgrade.doctriod

import android.app.Application
import com.upgrade.doctriod.di.DaggerApplicationComponent

class DocTriodApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()
}