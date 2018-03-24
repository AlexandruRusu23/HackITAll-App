package ro.hackitall.foodwaste.api

import com.burgstaller.okhttp.CachingAuthenticatorDecorator
import com.burgstaller.okhttp.digest.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.burgstaller.okhttp.digest.DigestAuthenticator
import com.burgstaller.okhttp.digest.CachingAuthenticator
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton

/**
 * Created by Emilian on 09/02/2018.
 *
 */

@Module
class  ApiClient {

    companion object {
        const val url = "https://hackitall.azurewebsites.net/api/";
    }

    @Provides
    @Singleton
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY


        val httpClient = OkHttpClient.Builder()
                //.authenticator(CachingAuthenticatorDecorator(authenticator, authCache))
                .addInterceptor(logging)

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson) : Retrofit{
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit : Retrofit) : ApiInterface = retrofit.create(ApiInterface::class.java)

}