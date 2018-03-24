package ro.hackitall.foodwaste.home.popup.injection

import dagger.Subcomponent
import ro.hackitall.foodwaste.home.popup.mvp.PopupFragment

/**
 * Created by Alex on 3/24/2018.
 *
 */
@Subcomponent(modules = arrayOf(PopupModule::class))
interface PopupComponent {
    fun inject (popupFragment: PopupFragment)
}