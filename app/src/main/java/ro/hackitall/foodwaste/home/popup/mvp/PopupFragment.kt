package ro.hackitall.foodwaste.home.popup.mvp

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.maps.MapsInitializer
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
import ro.hackitall.foodwaste.home.popup.injection.PopupModule
import kotlinx.android.synthetic.main.product_detail.*
import javax.inject.Inject

/**
 * Created by Alex on 3/24/2018.
 *
 */
class PopupFragment : BottomSheetDialogFragment(), PopupContract.PopupView{

    @Inject lateinit var popupPresenter : PopupPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DoNotWaste.appComponent.plus(PopupModule(this)).inject(this)

        try{
            MapsInitializer.initialize(activity)
        } catch (e : GooglePlayServicesNotAvailableException){
            e.printStackTrace()
        }

        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync(popupPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView?.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NO_FRAME, R.style.OrderBottomSheetDialogTheme)
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }
}