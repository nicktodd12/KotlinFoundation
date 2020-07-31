package com.example.kotlinfoundation.viewmodel

import com.example.kotlinfoundation.model.Todo
import io.reactivex.Observable

interface TypicodeViewModel {

    fun getTodosList() : Observable<List<Todo>>
}