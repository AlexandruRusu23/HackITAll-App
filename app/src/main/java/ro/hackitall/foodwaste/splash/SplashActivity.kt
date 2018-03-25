package ro.hackitall.foodwaste.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
import ro.hackitall.foodwaste.home.mvp.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DoNotWaste.appComponent.inject(this)

        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
                Runnable {
                    changeActivity()
                }, 1500)

    }

    fun changeActivity(){
        startActivity(Intent(this,HomeActivity::class.java))
        finish()
    }

}
