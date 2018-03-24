package ro.hackitall.foodwaste.api

import com.google.gson.JsonObject
import dagger.Module
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import ro.hackitall.foodwaste.home.model.User

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
    @GET("User/GetAll")
    fun getUsers(): Observable<User>

}