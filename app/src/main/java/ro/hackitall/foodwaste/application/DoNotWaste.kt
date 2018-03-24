package ro.hackitall.foodwaste.application

import android.app.Application
import ro.hackitall.foodwaste.dagger.components.AppComponent
import ro.hackitall.foodwaste.dagger.components.DaggerAppComponent

/**
 * Created by Emilian on 3/2/2018.
 *
 */

class DoNotWaste : Application(){
    companion object {
        @JvmStatic lateinit var instance : DoNotWaste
        @JvmStatic lateinit var appComponent : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.create()
    }
}