package com.example.devopsapplicatioin.data.local.repository

import androidx.lifecycle.LiveData
import com.example.devopsapplicatioin.data.local.dao.MaintItemDao
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.domain.local.repository.MainItemRepository
import com.example.devopsapplicatioin.util.ResultState
import javax.inject.Inject

class MaintItemRepositoryImpl @Inject constructor(private val maintItemDao: MaintItemDao):MainItemRepository {

    override fun GetMainItem(): LiveData<List<MainItem>> {
        return maintItemDao.GetMaintItem()
    }



    override suspend fun insertMainItem(mainitem: MainItem): ResultState<Unit> {
        return try {
            maintItemDao.insertMainItem(mainitem)
            ResultState.Success(Unit)
        }catch (e:java.lang.Exception){
            ResultState.Error(e.message ?: "Unknown Error")
        }
    }


}