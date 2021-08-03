package com.example.appliedvrcodechallenge.service

import com.example.appliedvrcodechallenge.model.Files
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface FileService {
    @Headers("mock:true")
    @GET("/files")
    fun getFiles() : Observable<Files>
}