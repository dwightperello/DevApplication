package com.example.devopsapplicatioin.domain.remote.usecase

import javax.inject.Inject

data class MainItemUseCases @Inject constructor(
    val getMainItemUseCase: getMainItemUseCase
)