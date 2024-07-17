package com.example.devopsapplicatioin.data.remote.network

import com.example.devopsapplicatioin.data.remote.model.mainItems
import retrofit2.http.GET

interface APIservice {

    @GET("/api/mainItems")
    suspend fun getMainItems():List<mainItems>
}