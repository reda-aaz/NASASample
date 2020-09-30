package com.example.nasasample.repo

import com.example.nasasample.model.data.PhotosContainer
import com.example.nasasample.model.network.RetrofitInstance
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository() {
    fun getPhotos(): Single<PhotosContainer>{
        return RetrofitInstance.getInstance().getPhotos().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}