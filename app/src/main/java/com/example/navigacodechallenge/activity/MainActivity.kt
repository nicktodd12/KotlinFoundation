package com.example.navigacodechallenge.activity

import android.app.DownloadManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.navigacodechallenge.R
import com.example.navigacodechallenge.viewmodel.FileViewModel
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import java.io.File
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var fileViewModel: FileViewModel

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = Handler(Looper.getMainLooper())
        val test: Runnable = object : Runnable {
            override fun run() {
                fetchFileUpdate()
                handler.postDelayed(this, 20000)
            }
        }
        handler.postDelayed(test, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun fetchFileUpdate() {
        compositeDisposable.add(fileViewModel.getFiles().subscribe({
            val path =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            it.files.forEach { file ->
                val filePath = File(path, file.friendlyName)
                if (!filePath.isFile) {
                    val request = DownloadManager.Request(
                        Uri.parse(file.url)
                    )
                        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                        .setTitle(file.friendlyName)
                        .setDescription("Downloading")
                        .setAllowedOverMetered(true)
                        .setDestinationInExternalPublicDir(
                            Environment.DIRECTORY_DOWNLOADS,
                            file.friendlyName
                        )
                    val dm: DownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
                    dm.enqueue(request)

                }
            }
        }, {
            Log.e(getString(R.string.error_text), it.message!!)
        }))
    }
}