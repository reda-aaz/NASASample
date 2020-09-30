package com.example.nasasample.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class PhotosContainer(val photos:List<Photo>) : Parcelable

@Parcelize
class Photo(
    @SerializedName("earth_date") val earthDate: String,
    @SerializedName("img_src") val url: String
) : Parcelable


//"albumId": 1,
//"id": 1,
//"title": "accusamus beatae ad facilis cum similique qui sunt",
//"url": "https://via.placeholder.com/600/92c952",
//"thumbnailUrl": "https://via.placeholder.com/150/92c952"