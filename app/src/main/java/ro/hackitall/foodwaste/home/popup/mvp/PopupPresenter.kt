package ro.hackitall.foodwaste.home.popup.mvp

import javax.inject.Inject

/**
 * Created by Alex on 3/24/2018.
 *
 */
class PopupPresenter : PopupContract.PopupPresenter {
    val popupView : PopupContract.PopupView

    @Inject constructor(popupView : PopupContract.PopupView){
        this.popupView = popupView
    }
}