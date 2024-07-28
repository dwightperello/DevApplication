package com.example.devopsapplicatioin.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.devopsapplicatioin.data.local.model.MainItem

@Dao
interface MaintItemDao {

    @Query("SELECT * FROM MainItem")
    fun GetMaintItem():LiveData<List<MainItem>>


    @Insert
    suspend fun insertMainItem(maintItem:MainItem)
}