package com.example.nasasample.testUtils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nasasample.model.data.PhotosContainer
import io.reactivex.Single
import retrofit2.Response

object APIUtil {
        fun successCall(data:PhotosContainer): Single<PhotosContainer> {
            return createCall(Response.success(data))
        }

    fun <T> createCall(response: Response<T>?): Single<PhotosContainer> {
        val data = Single.create<PhotosContainer> {
            it.onSuccess(response?.body() as PhotosContainer)
        }
        return data
    }
}