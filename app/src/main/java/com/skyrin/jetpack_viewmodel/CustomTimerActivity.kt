package com.skyrin.jetpack_viewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class CustomTimerActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(CustomTimerViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_timer)

        val tvTimer = findViewById<TextView>(R.id.tv_timer)

        viewModel.elapsedTime.observe(this, Observer {
            tvTimer.text = "$it seconds elapsed"
        })
    }
}
