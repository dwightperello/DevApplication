package com.example.devopsapplicatioin.presenter.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.devopsapplicatioin.domain.remote.usecase.getMainItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getmainItemUseCase: getMainItemUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment viewmodel"
    }
    val text: LiveData<String> = _text
}