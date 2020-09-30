package com.example.nasasample.model.network

import com.example.nasasample.model.data.PhotosContainer
import com.example.nasasample.utils.APOD_ENDPOINT
import io.reactivex.Single
import retrofit2.http.GET

//https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY

interface APIService {
    @GET(APOD_ENDPOINT)
    fun getPhotos(): Single<PhotosContainer>
}