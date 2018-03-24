package ro.hackitall.foodwaste.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import ro.hackitall.foodwaste.application.DoNotWaste
import javax.inject.Singleton

/**
 * Created by Emilian on 3/2/2018.
 *
 */

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext() : Context = DoNotWaste.instance

    @Provides
    @Singleton
    fun provideResources(context : Context) : Resources = context.resources

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context) : SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
}