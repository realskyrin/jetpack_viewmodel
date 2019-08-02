package com.skyrin.jetpack_viewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class ShareTimeFragment : Fragment(){
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(CustomTimerViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_share_time,container,false)
        val tvTimer = rootView.findViewById<TextView>(R.id.tv_timer)
        val btnReset = rootView.findViewById<Button>(R.id.btn_reset)

        viewModel.elapsedTime.observe(activity!!, Observer {
            tvTimer.text = "$it sec elapsed"
        })

        btnReset.setOnClickListener {
            viewModel.resetTime()
        }

        return rootView
    }

}