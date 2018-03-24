package ro.hackitall.foodwaste.home.popup.injection

import dagger.Module
import dagger.Provides
import ro.hackitall.foodwaste.home.popup.mvp.PopupContract
import ro.hackitall.foodwaste.home.popup.mvp.PopupPresenter

/**
 * Created by Alex on 3/24/2018.
 *
 */
@Module
class PopupModule(val popupView: PopupContract.PopupView) {

    @Provides
    fun provideView() : PopupContract.PopupView = popupView

    @Provides
    fun providePresenter(popupPresenter: PopupPresenter) : PopupContract.PopupPresenter = popupPresenter

}