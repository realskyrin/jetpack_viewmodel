package com.skyrin.jetpack_viewmodel

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.timerTask


class CustomTimerViewModel : ViewModel() {
    private var startTime: Long? = null

    private val _elapsedTime = MutableLiveData<Long>()
    var elapsedTime: LiveData<Long> = _elapsedTime

    init {
        startTime = SystemClock.elapsedRealtime()

        Timer().scheduleAtFixedRate(timerTask {
            val newValue = (SystemClock.elapsedRealtime() - startTime!!) / 1000
            _elapsedTime.postValue(newValue)
        }, ONE_SECOND, ONE_SECOND)
    }

    companion object {
        const val ONE_SECOND = 1000L
    }
}