package ro.hackitall.foodwaste.data

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import ro.hackitall.foodwaste.R

/**
 * Created by Emilian on 3/15/2018.
 *
 */
class Dialogs {
    companion object {
        private var loadingDialog: MaterialDialog? = null

        fun showLoadingDialog(context: Context, message : Int) {
            dismissLoadingDialog()
            loadingDialog = MaterialDialog.Builder(context)
                    .title(R.string.please_wait)
                    .content(message)
                    .progress(true,0)
                    .cancelable(false)
                    .widgetColorRes(R.color.colorPrimary)
                    .build()
            loadingDialog?.show()
        }

        fun dismissLoadingDialog() {
            if (loadingDialog?.isShowing == true) {
                loadingDialog?.dismiss()
                loadingDialog = null
            }
        }
    }
}