package com.example.devopsapplicatioin.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.devopsapplicatioin.data.local.dao.MaintItemDao
import com.example.devopsapplicatioin.data.local.model.MainItem

@Database(entities = [MainItem::class], version = 1)
abstract class DevOpsDatabase : RoomDatabase() {

    abstract fun providesMainItemName(): MaintItemDao

    companion object{
        private  var dbInstance:DevOpsDatabase?= null
        fun getAppDB(context: Context):DevOpsDatabase{
            if(dbInstance==null){
                dbInstance= Room.databaseBuilder<DevOpsDatabase>(
                    context.applicationContext,DevOpsDatabase::class.java,"DevOpsDatabaseDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbInstance!!
        }
    }
}