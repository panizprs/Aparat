package com.acm.workshop.aparat.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acm.workshop.aparat.R
import com.acm.workshop.aparat.app.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, HomeFragment())
            .commit()
    }
}
