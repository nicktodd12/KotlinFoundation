package com.example.navigacodechallenge.viewmodel

import com.example.navigacodechallenge.model.Files
import io.reactivex.Observable

interface FileViewModel {
    fun getFiles() : Observable<Files>
}