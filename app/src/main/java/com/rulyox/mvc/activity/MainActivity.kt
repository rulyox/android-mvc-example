package com.rulyox.mvc.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rulyox.mvc.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

    }

}
