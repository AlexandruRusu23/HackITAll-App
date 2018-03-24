package ro.hackitall.foodwaste.home.mvp.models

import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Emilian on 3/24/2018.
 *
 */

data class ProductModel (

        @SerializedName("productId")
        @Nullable
        val productId : String,

        @SerializedName("name")
        @Nullable
        val name : String,

        @SerializedName("picture")
        @Nullable
        val picture : String,

        @SerializedName("price")
        @Nullable
        val price: String,

        @SerializedName("quantity")
        @Nullable
        val quantity : String,

        @SerializedName("description")
        @Nullable
        val description : String,

        @SerializedName("users")
        @Nullable
        val store : StoreModel

) : Serializable
