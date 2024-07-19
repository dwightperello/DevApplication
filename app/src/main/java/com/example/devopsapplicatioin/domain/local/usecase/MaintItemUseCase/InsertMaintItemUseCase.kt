package com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase

import android.database.sqlite.SQLiteException
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.domain.local.repository.MainItemRepository
import com.example.devopsapplicatioin.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.sql.SQLException
import javax.inject.Inject

class InsertMaintItemUseCase @Inject constructor(private val mainitemrep: MainItemRepository) {

     suspend operator fun invoke(mainItem: MainItem):ResultState<Unit>{
         return mainitemrep.insertMainItem(mainItem)
     }
}
