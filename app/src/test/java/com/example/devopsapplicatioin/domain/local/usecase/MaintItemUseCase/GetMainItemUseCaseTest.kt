package com.example.devopsapplicatioin.domain.local.usecase.MaintItemUseCase
import android.database.sqlite.SQLiteException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.domain.local.repository.MainItemRepository
import com.example.devopsapplicatioin.util.ResultState
import com.example.getOrAwaitValue
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
class GetMainItemUseCaseTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainItemRepository: MainItemRepository

    private lateinit var observer: Observer<ResultState<List<MainItem>>>
    private lateinit var getMainItemUseCase: GetMainItemUseCase

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        getMainItemUseCase = GetMainItemUseCase(mainItemRepository)
    }

    @Test
    fun `test get all items from db`() {
        val items = listOf(
            MainItem(
                Name = "1"
            ),
            MainItem(
                Name = "2"
            )
        )
        val testData = MutableLiveData<List<MainItem>>()
        testData.value = items


        `when`(mainItemRepository.GetMainItem()).thenReturn(testData)
        val resultLiveData = getMainItemUseCase.invoke().getOrAwaitValue()
        assert(resultLiveData is ResultState.Success)
        assertEquals(items, (resultLiveData as ResultState.Success).data)

    }

    @Test
    fun `test handle SQLiteException`() {
        val exception = SQLiteException("Database error")

        `when`(mainItemRepository.GetMainItem()).thenThrow(exception)

        val resultLiveData = getMainItemUseCase.invoke().getOrAwaitValue()

        assert(resultLiveData is ResultState.Error)
        assertEquals("Database error: ${exception.message}", (resultLiveData as ResultState.Error).message)
    }

    @Test
    fun `test handle IllegalArgumentException`() {
        val exception = IllegalArgumentException("Invalid argument")

        `when`(mainItemRepository.GetMainItem()).thenAnswer { throw exception }

        val resultLiveData = getMainItemUseCase.invoke().getOrAwaitValue()

        assert(resultLiveData is ResultState.Error)
        assertEquals("Invalid argument: ${exception.message}", (resultLiveData as ResultState.Error).message)
    }

    @Test
    fun `test handle unexpected error`() {
        val exception = Exception("Unexpected error")

        `when`(mainItemRepository.GetMainItem()).thenAnswer { throw exception }

        val resultLiveData = getMainItemUseCase.invoke().getOrAwaitValue()

        assert(resultLiveData is ResultState.Error)
        assertEquals("Unexpected error: ${exception.message}", (resultLiveData as ResultState.Error).message)
    }


}