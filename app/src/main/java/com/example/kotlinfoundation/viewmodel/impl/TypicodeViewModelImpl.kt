package com.example.kotlinfoundation.viewmodel.impl

import com.example.kotlinfoundation.model.Todo
import com.example.kotlinfoundation.service.TypicodeService
import com.example.kotlinfoundation.viewmodel.TypicodeViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class TypicodeViewModelImpl @Inject constructor(var typicodeService: TypicodeService) : TypicodeViewModel {
    override fun getTodosList(): Observable<List<Todo>> {
        return typicodeService.getTodosList().compose{ it.observeOn(AndroidSchedulers.mainThread()) }
    }
}