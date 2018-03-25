package ro.hackitall.foodwaste.home.popup.mvp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.maps.MapsInitializer
import com.squareup.picasso.Picasso
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
import ro.hackitall.foodwaste.home.popup.injection.PopupModule
import kotlinx.android.synthetic.main.product_detail.*
import java.util.*
import javax.inject.Inject

/**
 * Created by Alex on 3/24/2018.
 *
 */
class PopupFragment : BottomSheetDialogFragment(), PopupContract.PopupView {

    @Inject lateinit var popupPresenter: PopupPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DoNotWaste.appComponent.plus(PopupModule(this)).inject(this)

        try {
            MapsInitializer.initialize(activity)
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }

        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync(popupPresenter)
        initializeView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView?.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NO_FRAME, R.style.OrderBottomSheetDialogTheme)
    }

    override fun initializeView() {
        //Picasso.with(activity).load(arguments?.getByteArray("picture")).placeholder(R.drawable.cartofi).into(productImage)
        Glide.with(activity!!).load(Base64.decode(arguments?.getString("picture"), Base64.DEFAULT)).into(productImage!!)
        productName.text = arguments?.getString("name")
        productDescription.text = arguments?.getString("description")
        productShop.text = arguments?.getString("store")
        productPrice.text = arguments?.getString("price") + " RON"
    }

    override fun setStoreLocation() {
        popupPresenter.setStoreLocation(arguments!!.getDouble("latitude"), arguments!!.getDouble("longitude"))
    }

    override fun openGoogleMaps() {
        val uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%f,%f",
                arguments?.getDouble("latitude"), arguments?.getDouble("longitude"),
                arguments?.getDouble("latitude"), arguments?.getDouble("longitude"))
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri+"("+arguments?.getString("store")+")"))
        activity?.startActivity(intent)
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