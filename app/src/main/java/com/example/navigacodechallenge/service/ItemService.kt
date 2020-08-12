package com.example.navigacodechallenge.service

import com.example.navigacodechallenge.model.Item
import io.reactivex.Observable
import retrofit2.http.GET

interface ItemService {
    @GET("fizzbuzz.json.gz")
    fun getItemList() : Observable<List<Item>>
}