package com.example.devopsapplicatioin.presenter.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.data.remote.model.mainItems
import com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase.MaintItem_UseCases
import com.example.devopsapplicatioin.domain.remote.usecase.MainItemUseCases
import com.example.devopsapplicatioin.domain.remote.usecase.getMainItemUseCase
import com.example.devopsapplicatioin.util.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class HomeViewModel @Inject constructor(private val  mainitemUsecases: MainItemUseCases,
                                        private val mainItem_usecase : MaintItem_UseCases) : ViewModel() {

    private val _mainItems:MutableLiveData<ResultState<List<mainItems>>> = MutableLiveData()
    val mainItems:LiveData<ResultState<List<mainItems>>> get() = _mainItems

    private val _insert:MutableLiveData<ResultState<Unit>> = MutableLiveData()
    val insert:LiveData<ResultState<Unit>> get() = _insert

    val itemFromDb = mainItem_usecase.getMainItemUsecaseDb()




    init {
        getMainItems()
    }

    private fun getMainItems() {
        viewModelScope.launch {
            mainitemUsecases.getMainItemUseCase().onEach {
                _mainItems.postValue(it)
            }.launchIn(viewModelScope)
        }
    }

    fun insertitem(mainitem:MainItem){
        viewModelScope.launch {
         val result= mainItem_usecase.insertMainItem(mainitem)
            _insert.value = result
        }
    }
}