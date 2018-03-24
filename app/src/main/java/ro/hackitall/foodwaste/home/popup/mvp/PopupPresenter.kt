package ro.hackitall.foodwaste.home.popup.mvp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.product_detail.*
import ro.hackitall.foodwaste.R
import javax.inject.Inject

/**
 * Created by Alex on 3/24/2018.
 *
 */
class PopupPresenter : PopupContract.PopupPresenter, OnMapReadyCallback {

    val popupView: PopupContract.PopupView

    val context: Context

    private var mMap: GoogleMap? = null

    @Inject constructor(popupView: PopupContract.PopupView,
                        context: Context) {
        this.popupView = popupView
        this.context = context
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        mMap = googleMap
        mMap?.setMaxZoomPreference(15.0f)
        mMap?.setMinZoomPreference(15.0f)

        //mMap?.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style))

        popupView.setStoreLocation()
        Log.d("PopupPresenter", "Map Ready")
    }

    override fun setStoreLocation(latitude: Double, longitude: Double) {
        mMap?.addMarker(MarkerOptions().position(LatLng(latitude, longitude)))
        mMap?.animateCamera(CameraUpdateFactory.newLatLng(LatLng(latitude, longitude)))
        mMap?.setOnMapClickListener {
            popupView.openGoogleMaps()
        }
    }

}