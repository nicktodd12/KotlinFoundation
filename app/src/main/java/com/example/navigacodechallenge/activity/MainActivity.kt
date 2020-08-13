package com.example.navigacodechallenge.activity

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigacodechallenge.R
import com.example.navigacodechallenge.adapter.ItemAdapter
import com.example.navigacodechallenge.viewmodel.ItemViewModel
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var itemViewModel: ItemViewModel

    @Inject
    lateinit var picasso: Picasso

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        item_recyclerview.apply {
            layoutManager = LinearLayoutManager(this.context)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

    }

    override fun onResume() {
        super.onResume()
        compositeDisposable.add(itemViewModel.getItemList().subscribe {
            item_recyclerview.adapter = ItemAdapter(it, picasso)
        })
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }
}