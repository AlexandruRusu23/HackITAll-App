package ro.hackitall.foodwaste.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.application.DoNotWaste
import ro.hackitall.foodwaste.home.mvp.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DoNotWaste.appComponent.inject(this)

        setContentView(R.layout.activity_splash)

        splash_button.setOnClickListener{
            finish()
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
