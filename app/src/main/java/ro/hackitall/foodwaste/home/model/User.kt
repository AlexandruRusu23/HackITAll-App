package ro.hackitall.foodwaste.home.model

import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Emilian on 3/24/2018.
 *
 */

data class User(

        @SerializedName("userId")
        @Nullable
        val userId : String,

        @SerializedName("username")
        @Nullable
        val username : String,

        @SerializedName("password")
        @Nullable
        val password : String,

        @SerializedName("email")
        @Nullable
        val email : String,

        @SerializedName("role")
        @Nullable
        val role : String

) :Serializable