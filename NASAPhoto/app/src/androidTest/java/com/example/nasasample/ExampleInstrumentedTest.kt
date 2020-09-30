package com.example.nasasample

import androidx.lifecycle.LiveData
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nasasample.testUtils.APIUtil
import com.example.nasasample.model.data.PhotosContainer
import com.example.nasasample.repo.Repository
import com.example.nasasample.testUtils.LIST_TEST_PHOTO
import com.example.nasasample.testUtils.SingleUtil
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.Single

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @MockK
    private lateinit var repoService:Repository


    @Before
    fun setUpRules() {
        MockKAnnotations.init(this)
        repoService= Repository()
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test_return_success() {
        //Arrange
        val call: Single<PhotosContainer> =
            APIUtil.successCall(
                PhotosContainer(
                    photos = LIST_TEST_PHOTO
                )
            )

        val singletestUtil = SingleUtil<PhotosContainer>()
        //Act
        every { repoService.getPhotos() }answers {call}
        //Verify
        val returnedValue = singletestUtil.getValue(repoService.getPhotos())
        assertEquals(returnedValue?.photos?.size, LIST_TEST_PHOTO.size)
    }
}