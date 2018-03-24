package ro.hackitall.foodwaste.home.injection

import dagger.Subcomponent
import ro.hackitall.foodwaste.home.mvp.HomeActivity

/**
 * Created by Emilian on 3/24/2018.
 *
 */

@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject (homeActivity: HomeActivity)
}
