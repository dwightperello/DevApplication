package com.example.devopsapplicatioin.domain.local.repository

import androidx.lifecycle.LiveData
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.util.ResultState

interface MainItemRepository {

    fun GetMainItem():LiveData<List<MainItem>>



    suspend fun insertMainItem(mainitem:MainItem):ResultState<Unit>
}