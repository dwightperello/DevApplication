package com.example.devopsapplicatioin.domain.remote.repository

import com.example.devopsapplicatioin.data.remote.model.mainItems

interface maintItemRepository {

    suspend fun getMainItems():List<mainItems>
}