package com.example.navigacodechallenge.viewmodel.impl

import com.example.navigacodechallenge.model.Item
import com.example.navigacodechallenge.service.ItemService
import com.example.navigacodechallenge.viewmodel.ItemViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Implementation of the Item viewmodel
 */
class ItemViewModelImpl @Inject constructor(var itemService: ItemService) : ItemViewModel {
    override fun getItemList(): Observable<List<Item>> {
        //return the item list from the service layer and return on the main thread
        return itemService.getItemList().compose{ it.observeOn(AndroidSchedulers.mainThread()) }
    }
}