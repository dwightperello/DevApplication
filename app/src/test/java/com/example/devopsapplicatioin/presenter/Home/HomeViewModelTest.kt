package com.example.devopsapplicatioin.presenter.Home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
class HomeViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel : HomeViewModel

    @Before
    fun setup(){
        //viewModel = HomeViewModel(FakeRepo())
    }
}