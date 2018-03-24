package ro.hackitall.foodwaste.home.mvp.models

import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by Emilian on 3/24/2018.
 *
 */

data class GetProductsResponse (

        @SerializedName("Products")
        @Nullable
        val products : Array<ProductModel>

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GetProductsResponse

        if (!Arrays.equals(products, other.products)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(products)
    }
}