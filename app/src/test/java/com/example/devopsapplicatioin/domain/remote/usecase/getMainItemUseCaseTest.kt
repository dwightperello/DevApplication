package com.example.devopsapplicatioin.domain.remote.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.devopsapplicatioin.data.remote.model.mainItems
import com.example.devopsapplicatioin.domain.local.repository.MainItemRepository
import com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase.GetMainItemUseCase
import com.example.devopsapplicatioin.domain.remote.repository.maintItemRepository
import com.example.devopsapplicatioin.util.ResultState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class getMainItemUseCaseTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainItemRepository: maintItemRepository

    private lateinit var getRemoteMaintItemRepository  : getMainItemUseCase

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        getRemoteMaintItemRepository = getMainItemUseCase(mainItemRepository)
    }

    @Test
    fun `get all item from remote test and return success`() = runBlocking{
       `when` (mainItemRepository.getMainItems()).thenReturn(sample.sampleMainItems)
        val dataItemFlow = getRemoteMaintItemRepository.invoke()
        val results = mutableListOf<ResultState<List<mainItems>>>()
        dataItemFlow.toList(results)
        assertTrue(results[0] is ResultState.Loading)
        assertTrue(results[1] is ResultState.Success)
        val dataItems = (results[1] as ResultState.Success).data
        assertTrue(dataItems is List<*>)
        assertTrue(dataItems!!.isNotEmpty())
        val description = dataItems[0].description
        assertEquals("Main item description 1",description)


    }

    @Test
    fun `get all item from remote test and return error`() = runBlocking {
        // Mock the repository to throw an exception
        val exceptionMessage = "Error on getting main items"
        `when`(mainItemRepository.getMainItems()).thenThrow(RuntimeException(exceptionMessage))

        // Collect the flow emitted by the use case
        val dataItemFlow = getRemoteMaintItemRepository.invoke()
        val results = mutableListOf<ResultState<List<mainItems>>>()
        dataItemFlow.toList(results)

        // Verify the emitted values
        assertTrue(results[0] is ResultState.Loading)
        assertTrue(results[1] is ResultState.Error)
        val errorState = results[1] as ResultState.Error
        assertTrue(errorState.message == exceptionMessage)
    }
}