package com.example.appliedvrcodechallenge.viewmodel.impl

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import com.example.appliedvrcodechallenge.model.Files
import com.example.appliedvrcodechallenge.service.FileService
import com.example.appliedvrcodechallenge.viewmodel.FileViewModel
/**
 * Implementation of the File viewmodel
 */
class FileViewModelImpl @Inject constructor(var fileService: FileService) : FileViewModel {
    override fun getFiles(): Observable<Files> {
        //return the file list from the service layer and return on the main thread
        return fileService.getFiles().compose{ it.observeOn(AndroidSchedulers.mainThread()) }
    }
}