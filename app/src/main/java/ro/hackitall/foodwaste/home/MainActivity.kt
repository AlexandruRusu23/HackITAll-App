package ro.hackitall.foodwaste.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.api.ApiInterface
import ro.hackitall.foodwaste.application.DoNotWaste
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var apiInterface : ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DoNotWaste.appComponent.inject(this)

        setContentView(R.layout.activity_main)

        val observable = apiInterface.getUsers()
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result -> text.setText(result.email)},
                           {error -> text.setText("Api error")})
    }
}
