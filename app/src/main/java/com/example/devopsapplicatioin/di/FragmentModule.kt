package com.example.devopsapplicatioin.di

import com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase.GetMainItemUseCase
import com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase.InsertMaintItemUseCase
import com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase.MaintItem_UseCases
import com.example.devopsapplicatioin.domain.remote.usecase.MainItemUseCases
import com.example.devopsapplicatioin.domain.remote.usecase.getMainItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    @FragmentScoped
    fun provideMainItem_UseCases(getmainItemUseCase: getMainItemUseCase): MainItemUseCases {
        return  MainItemUseCases(getmainItemUseCase)
    }

    @Provides
    @FragmentScoped
    fun provideMaintItemUsecases(
        getmaintitem:GetMainItemUseCase,
        insertmaintitem:InsertMaintItemUseCase): MaintItem_UseCases{
        return MaintItem_UseCases(insertmaintitem,getmaintitem)
    }
}