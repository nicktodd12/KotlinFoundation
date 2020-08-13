package com.example.navigacodechallenge.viewmodel

import com.example.navigacodechallenge.model.Item
import io.reactivex.Observable

/**
 * Viewmodel interface for items
 */
interface ItemViewModel {

    fun getItemList() : Observable<List<Item>>
}