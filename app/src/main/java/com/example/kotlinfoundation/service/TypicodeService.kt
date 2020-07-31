package com.example.kotlinfoundation.service

import com.example.kotlinfoundation.model.Todo
import io.reactivex.Observable
import retrofit2.http.GET

interface TypicodeService {
    @GET("todos")
    fun getTodosList() : Observable<List<Todo>>
}