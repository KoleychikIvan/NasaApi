package com.koleychik.nasaapi.models.mainModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EarthImageModel(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("date")
    val date: String
) : Parcelable