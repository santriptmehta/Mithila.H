package com.santriptmehta.mithilah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadSplashScreen()

    }
        private var TIME_OUT:Long = 3000

    private fun loadSplashScreen(){
        Handler().postDelayed({
            var intent = Intent(this, drawer::class.java)
            startActivity(intent)

        },TIME_OUT)
    }


}