package com.example.devopsapplicatioin.domain.remote.usecase

import com.example.devopsapplicatioin.data.remote.model.mainItems
import com.example.devopsapplicatioin.domain.remote.repository.maintItemRepository
import com.example.devopsapplicatioin.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class getMainItemUseCase @Inject constructor(private val maintItemRepository: maintItemRepository) {

    operator fun invoke(): Flow<ResultState<List<mainItems>>> = flow {
        try {
            emit(ResultState.Loading())
            val items= maintItemRepository.getMainItems()
            emit(ResultState.Success<List<mainItems>>(items))
        }
        catch (e:Exception){
            emit(ResultState.Error<List<mainItems>>(e.message ?: "Error on getting main items"))
        }
    }
}