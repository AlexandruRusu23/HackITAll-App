package ro.hackitall.foodwaste.api

import dagger.Module
import io.reactivex.Observable
import retrofit2.http.*
import ro.hackitall.foodwaste.home.mvp.models.GetProductsResponse
import ro.hackitall.foodwaste.home.mvp.models.StoreModel

/**
 * Created by Emilian on 09/02/2018.
 *
 */
@Module
interface ApiInterface {

    companion object {
        const val AUTHORIZATION = "WWW-Authenticate: Basic realm=\"Private area\""
    }

    //@Headers(AUTHORIZATION)
    @GET("StoreModel/GetAll")
    fun getUsers(): Observable<StoreModel>

    @GET("Product/GetAll")
    fun getProducts() : Observable<GetProductsResponse>

}