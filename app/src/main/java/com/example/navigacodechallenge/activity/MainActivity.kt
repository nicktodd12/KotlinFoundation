package com.example.navigacodechallenge.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigacodechallenge.R
import com.example.navigacodechallenge.adapter.ItemAdapter
import com.example.navigacodechallenge.viewmodel.FileViewModel
import com.example.navigacodechallenge.viewmodel.ItemViewModel
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var itemViewModel: ItemViewModel

    @Inject
    lateinit var fileViewModel: FileViewModel

    @Inject
    lateinit var picasso: Picasso

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner.visibility = View.VISIBLE
        item_recyclerview.apply {
            layoutManager = LinearLayoutManager(this.context)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onResume() {
        super.onResume()
        //add subscription to disposable and set up adapter with result
        /*compositeDisposable.add(itemViewModel.getItemList().subscribe ({
            item_recyclerview.adapter = ItemAdapter(it, picasso)
        }, {
            Log.e(getString(R.string.error_text), it.message!!)
            Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_SHORT).show();
        }, {
            spinner.visibility = View.GONE
        }))*/
        compositeDisposable.add(fileViewModel.getFiles().subscribe ({
            val f = it.files.get(0)
            Log.d("Test", "Here")
        }, {
            Log.e(getString(R.string.error_text), it.message!!)
        }))
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }
}