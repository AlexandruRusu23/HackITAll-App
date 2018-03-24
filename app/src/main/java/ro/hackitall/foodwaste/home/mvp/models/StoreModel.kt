package ro.hackitall.foodwaste.home.mvp.models

import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Emilian on 3/24/2018.
 *
 */

data class StoreModel(

        @SerializedName("userId")
        @Nullable
        val storeId : String,

        @SerializedName("username")
        @Nullable
        val username : String,

        @SerializedName("latitude")
        @Nullable
        val latitude : Double,

        @SerializedName("longitude")
        @Nullable
        val longitude : Double

) :Serializable