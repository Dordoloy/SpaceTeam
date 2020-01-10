package com.example.spaceteam.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ScoreViewModel {

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    
    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }

}