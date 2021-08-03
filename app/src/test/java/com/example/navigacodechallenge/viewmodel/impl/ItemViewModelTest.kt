package com.example.navigacodechallenge.viewmodel.impl

import com.example.navigacodechallenge.BaseRxTest
import com.example.navigacodechallenge.model.File
import com.example.navigacodechallenge.model.Files
import com.example.navigacodechallenge.service.FileService
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import java.net.SocketTimeoutException

/**
 * Tests functionality of the FileViewModel
 */
@RunWith(MockitoJUnitRunner::class)
class FileViewModelTest : BaseRxTest() {
    lateinit var fileViewModel: FileViewModelImpl
    lateinit var fileService: FileService

    @Before
    fun setup() {
        fileService = Mockito.mock(FileService::class.java)
        fileViewModel = FileViewModelImpl(fileService)
    }

    @Test
    fun testGetItems() {
        val fileListResponse = Files(arrayListOf())
        Mockito.`when`(fileService.getFiles()).thenReturn(Observable.just(fileListResponse))
        val testObserver = TestObserver<Files>()
        fileViewModel.getFiles().subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver.assertValue(fileListResponse)
    }

    @Test
    fun testGetItemsFailure() {
        Mockito.`when`(fileService.getFiles())
            .thenReturn(Observable.error(SocketTimeoutException()))

        val testObserver = TestObserver<Files>()
        fileViewModel.getFiles().subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver.assertError(SocketTimeoutException::class.java)
    }
}
