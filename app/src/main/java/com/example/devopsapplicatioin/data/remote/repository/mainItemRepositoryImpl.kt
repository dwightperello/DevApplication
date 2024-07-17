package com.example.devopsapplicatioin.data.remote.repository

import com.example.devopsapplicatioin.data.remote.model.mainItems
import com.example.devopsapplicatioin.data.remote.network.APIservice
import com.example.devopsapplicatioin.domain.remote.repository.maintItemRepository
import javax.inject.Inject

class mainItemRepositoryImpl @Inject constructor(private val apIservice: APIservice):
    maintItemRepository {

    override suspend fun getMainItems(): List<mainItems> = apIservice.getMainItems()



}