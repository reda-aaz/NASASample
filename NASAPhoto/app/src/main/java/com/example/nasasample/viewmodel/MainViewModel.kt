package com.example.nasasample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasasample.model.data.Photo
import com.example.nasasample.model.data.PhotosContainer
import com.example.nasasample.repo.Repository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: Repository): ViewModel() {
    private val disposable = CompositeDisposable()
    private val _photoLiveData = MutableLiveData<List<Photo>>()
    val photoLiveData : LiveData<List<Photo>>
        get() {
            return _photoLiveData
        }


    fun getPhotos(){
        disposable.add(
        repository.getPhotos().subscribe {
            t: PhotosContainer? ->  _photoLiveData.value = t?.photos
        }
        )
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}