package com.example.devopsapplicatioin.presenter.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment viewmodel"
    }
    val text: LiveData<String> = _text
}