package ro.hackitall.foodwaste.home.popup.mvp

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
import ro.hackitall.foodwaste.home.popup.injection.PopupModule
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
    }
}