package com.example.devopsapplicatioin.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class MainItem(
    @PrimaryKey(autoGenerate = true) val Id: Int=0,
    val Name:String
):Parcelable

