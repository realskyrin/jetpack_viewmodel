package com.skyrin.jetpack_viewmodel

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (viewModel.startTime == null) {
            val startTime = SystemClock.elapsedRealtime()
            viewModel.startTime = startTime
            cm.base = startTime
        } else {
            cm.base = viewModel.startTime!!
        }

        cm.start()
    }
}
