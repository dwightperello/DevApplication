package com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase


import android.database.sqlite.SQLiteException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.domain.local.repository.MainItemRepository
import com.example.devopsapplicatioin.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.sql.SQLException
import javax.inject.Inject

class GetMainItemUseCase @Inject constructor (private val maintitemrepo: MainItemRepository) {

      operator fun invoke(): LiveData<ResultState<List<MainItem>>>  {
            val liveData = MutableLiveData<ResultState<List<MainItem>>>()
            liveData.value = ResultState.Loading()
            try {
                  maintitemrepo.GetMainItem().observeForever{items->
                        if(items!= null) liveData.value = ResultState.Success(items)
                        else liveData.value = ResultState.Error("NO ITEM FOUND")
                  }

            } catch (e: Exception) {
                  liveData.value = handleException(e)

            }
            return liveData
      }

      private fun handleException(e: Throwable): ResultState.Error<List<MainItem>> {
            return when (e) {
                  is SQLiteException -> ResultState.Error("Database error: ${e.message}")
                  is SQLException -> ResultState.Error("SQL error: ${e.message}")
                  is IllegalArgumentException -> ResultState.Error("Invalid argument: ${e.message}")
                  is IOException -> ResultState.Error("I/O error: ${e.message}")
                  else -> ResultState.Error("Unexpected error: ${e.message}")
            }
      }
}