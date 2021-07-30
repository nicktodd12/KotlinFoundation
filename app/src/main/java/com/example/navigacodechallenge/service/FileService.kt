package com.example.navigacodechallenge.service

import com.example.navigacodechallenge.model.Files
import com.example.navigacodechallenge.model.Item
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface FileService {
    @Headers("mock:true")
    @GET("/files")
    fun getFiles() : Observable<Files>
}