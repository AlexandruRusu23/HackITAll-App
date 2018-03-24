package ro.hackitall.foodwaste.home.popup.mvp

/**
 * Created by Alex on 3/24/2018.
 *
 */
interface PopupContract {

    interface PopupView {
        fun initializeView()
        fun setStoreLocation()
        fun openGoogleMaps()
    }

    interface PopupPresenter {
        fun setStoreLocation(latitude : Double, longitude : Double)
    }

}