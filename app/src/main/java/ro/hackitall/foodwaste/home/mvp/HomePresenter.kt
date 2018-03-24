package ro.hackitall.foodwaste.home.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ro.hackitall.foodwaste.api.ApiInterface
import ro.hackitall.foodwaste.home.mvp.models.ProductModel
import javax.inject.Inject

/**
 * Created by Emilian on 3/24/2018.
 *
 */

class HomePresenter : HomeContract.HomePresenter {

    val homeView : HomeContract.HomeView

    val apiInterface : ApiInterface

    @Inject constructor(homeView: HomeContract.HomeView,
                        apiInterface: ApiInterface){
        this.homeView = homeView
        this.apiInterface = apiInterface
    }

    override fun getProducts() {
        val observable = apiInterface.getProducts()
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe( {result -> onSuccess(result.products)},
                            { error -> onFailure()})
    }

    override fun onSuccess(products: Array<ProductModel>) {
        homeView.onGetProductsSuccess(products)
    }

    override fun onFailure() {
        homeView.onGetProductsFailure()
    }

}