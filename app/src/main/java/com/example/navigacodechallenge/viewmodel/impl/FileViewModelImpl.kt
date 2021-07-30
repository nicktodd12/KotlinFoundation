package com.example.navigacodechallenge.viewmodel.impl

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import com.example.navigacodechallenge.model.Files
import com.example.navigacodechallenge.service.FileService
import com.example.navigacodechallenge.viewmodel.FileViewModel
/**
 * Implementation of the Item viewmodel
 */
class FileViewModelImpl @Inject constructor(var fileService: FileService) : FileViewModel {
    override fun getFiles(): Observable<Files> {
        //return the item list from the service layer and return on the main thread
        return fileService.getFiles().compose{ it.observeOn(AndroidSchedulers.mainThread()) }
    }
}