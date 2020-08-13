package com.example.navigacodechallenge.viewmodel.impl

import com.example.navigacodechallenge.BaseRxTest
import com.example.navigacodechallenge.model.Item
import com.example.navigacodechallenge.service.ItemService
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import java.net.SocketTimeoutException

/**
 * Tests functionality of the ItemViewModel
 */
@RunWith(MockitoJUnitRunner::class)
class ItemViewModelTest : BaseRxTest() {
    lateinit var itemViewModel: ItemViewModelImpl
    lateinit var itemService: ItemService

    @Before
    fun setup() {
        itemService = Mockito.mock(ItemService::class.java)
        itemViewModel = ItemViewModelImpl(itemService)
    }

    @Test
    fun testGetItems() {
        val itemListResponse = ArrayList<Item>()
        Mockito.`when`(itemService.getItemList()).thenReturn(Observable.just(itemListResponse))
        val testObserver = TestObserver<List<Item>>()
        itemViewModel.getItemList().subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver.assertValue(itemListResponse)
    }

    @Test
    fun testGetItemsFailure() {
        Mockito.`when`(itemService.getItemList())
            .thenReturn(Observable.error(SocketTimeoutException()))

        val testObserver = TestObserver<List<Item>>()
        itemViewModel.getItemList().subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver.assertError(SocketTimeoutException::class.java)
    }
}
