package com.example.nasasample.testUtils

import androidx.lifecycle.Observer
import com.example.nasasample.model.data.PhotosContainer
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


class SingleUtil<T> {
    @Throws(InterruptedException::class)
    fun getValue(single: Single<T>): T? {
        var data: T? = null

        val compositeDisposable = CompositeDisposable()


        // latch for blocking thread until data is set
        val latch = CountDownLatch(1)

        val observer: Observer<T> = object : Observer<T> {
            override fun onChanged(t: T) {
            data = t
            latch.countDown() // release the latch
        }
    }

        compositeDisposable.add(single.subscribe{
            t: T ->  data = t
            latch.countDown()
        })
        try {
            latch.await(2, TimeUnit.SECONDS) // wait for onChanged to fire and set data
        } catch (e: InterruptedException) {
            throw InterruptedException("Latch failure")
        }
        return data
    }
}