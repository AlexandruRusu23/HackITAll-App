package ro.hackitall.foodwaste.home.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
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

        homePresenter.getProducts()
    }

    override fun onGetProductsSuccess(products: Array<ProductModel>) {
        val productsAdapter = ProductAdapter(this, products)
        productRecycler.adapter = productsAdapter
    }

    override fun onGetProductsFailure() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
    }


}
