package ro.hackitall.foodwaste.dagger.components

import dagger.Component
import ro.hackitall.foodwaste.api.ApiClient
import ro.hackitall.foodwaste.dagger.modules.AppModule
import ro.hackitall.foodwaste.home.injection.HomeComponent
import ro.hackitall.foodwaste.home.injection.HomeModule
import ro.hackitall.foodwaste.splash.SplashActivity
import javax.inject.Singleton

/**
 * Created by Emilian on 3/2/2018.
 *
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiClient::class))
interface AppComponent {
    fun inject(splashActivity: SplashActivity)
    fun plus(homeModule: HomeModule) : HomeComponent
}
