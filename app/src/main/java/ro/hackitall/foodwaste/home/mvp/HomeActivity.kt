package ro.hackitall.foodwaste.home.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
import ro.hackitall.foodwaste.data.Dialogs
import ro.hackitall.foodwaste.home.adapters.ProductAdapter
import ro.hackitall.foodwaste.home.injection.HomeModule
import ro.hackitall.foodwaste.home.mvp.models.ProductModel
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.HomeView {

    @Inject lateinit var homePresenter : HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DoNotWaste.appComponent.plus(HomeModule(this)).inject(this);

        setContentView(R.layout.activity_main)

        productRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        Dialogs.showLoadingDialog(this, R.string.get_products)
        homePresenter.getProducts()
    }

    override fun onGetProductsSuccess(products: Array<ProductModel>) {
        val productsAdapter = ProductAdapter(this, products)
        productRecycler.adapter = productsAdapter
        Dialogs.dismissLoadingDialog()
    }

    override fun onGetProductsFailure() {
        Dialogs.dismissLoadingDialog()
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
    }


}
