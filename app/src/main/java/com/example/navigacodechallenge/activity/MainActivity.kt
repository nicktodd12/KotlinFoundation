package com.example.navigacodechallenge.activity

import android.Manifest
import android.app.DownloadManager
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigacodechallenge.R
import com.example.navigacodechallenge.viewmodel.FileViewModel
import com.example.navigacodechallenge.viewmodel.ItemViewModel
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    private val WRITE_EXTERNAL_STORAGE = 0
    private val REQUEST_PERMISSION = 0

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
        /*if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), WRITE_EXTERNAL_STORAGE)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_PERMISSION)
        }*/

        compositeDisposable.add(fileViewModel.getFiles().subscribe({
            val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val file = File(path, it.files[0].friendlyName)
            if (!file.isFile) {
                val request = DownloadManager.Request(
                    Uri.parse(it.files[0].url)
                )
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE) // Visibility of the download Notification
                    .setTitle(it.files.get(0).friendlyName) // Title of the Download Notification
                    .setDescription("Downloading") // Description of the Download Notification
                    .setAllowedOverMetered(true)
                    .setDestinationInExternalPublicDir(
                        Environment.DIRECTORY_DOWNLOADS,
                        it.files[0].friendlyName
                    )
                val dm: DownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
                dm.enqueue(request)
            }
        }, {
            Log.e(getString(R.string.error_text), it.message!!)
        }, {
            spinner.visibility = View.GONE
        }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}