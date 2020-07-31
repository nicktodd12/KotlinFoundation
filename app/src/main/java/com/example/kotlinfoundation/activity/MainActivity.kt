package com.example.kotlinfoundation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfoundation.R
import com.example.kotlinfoundation.application.KotlinFoundationApplication
import com.example.kotlinfoundation.viewmodel.TypicodeViewModel
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var typicodeViewModel: TypicodeViewModel

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        compositeDisposable.add(typicodeViewModel.getTodosList().subscribe {
            var output : String = ""
            for (t in it) {
                output += t.title + "\n"
            }
            body_text.text = output
        })
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }
}