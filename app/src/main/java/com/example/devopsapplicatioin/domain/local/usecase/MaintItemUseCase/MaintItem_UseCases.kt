package com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase

import javax.inject.Inject

data class MaintItem_UseCases @Inject constructor(
    val insertMainItem:InsertMaintItemUseCase,
    val getMainItemUsecaseDb : GetMainItemUseCase,

)
