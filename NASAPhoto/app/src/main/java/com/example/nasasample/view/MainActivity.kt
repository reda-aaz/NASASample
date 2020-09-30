package com.example.nasasample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.nasasample.R
import com.example.nasasample.model.data.Photo
import com.example.nasasample.repo.Repository
import com.example.nasasample.view.adapter.PhotoAdapter
import com.example.nasasample.viewmodel.MainViewModel
import com.example.nasasample.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity(), PhotoAdapter.PhotoItemListener {
    lateinit var mainViewModel: MainViewModel
    lateinit var mainViewModelFactory: MainViewModelFactory
    lateinit var repository: Repository
    lateinit var recyclerView: RecyclerView
    lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        photoAdapter = PhotoAdapter(this)
        recyclerView = findViewById(R.id.photo_recyclerView)
        recyclerView.adapter= photoAdapter
        repository = Repository()
        mainViewModelFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
        mainViewModel.getPhotos()
        mainViewModel.photoLiveData.observe(this, Observer {
            photoAdapter.listPhoto = it
        })


    }

    override fun onClickItem(photo: Photo) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key", photo)
        startActivity(intent)
    }
}