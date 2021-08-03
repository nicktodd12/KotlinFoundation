package com.example.appliedvrcodechallenge.viewmodel

import com.example.appliedvrcodechallenge.model.Files
import io.reactivex.Observable

interface FileViewModel {
    fun getFiles() : Observable<Files>
}