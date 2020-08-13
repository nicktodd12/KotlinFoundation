package com.example.navigacodechallenge.service

import com.example.navigacodechallenge.model.Item
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The service for fetching the list of items
 */
interface ItemService {
    @GET("fizzbuzz.json.gz")
    fun getItemList() : Observable<List<Item>>
}