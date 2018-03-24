package ro.hackitall.foodwaste.home.mvp

import ro.hackitall.foodwaste.home.mvp.models.ProductModel

/**
 * Created by Emilian on 3/24/2018.
 *
 */

interface HomeContract{

    interface HomeView {
        fun onGetProductsSuccess(products : Array<ProductModel>)
        fun onGetProductsFailure()
    }

    interface HomePresenter{
        fun getProducts()
        fun onSuccess(products: Array<ProductModel>)
        fun onFailure()
    }

}
