package com.accretion.mytaskapp.modal.search_movie

import android.os.Parcel
import android.os.Parcelable

data class MovieResult(
    val adult: Boolean?,
    val backdrop_path: String?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(adult)
        parcel.writeString(backdrop_path)
        parcel.writeValue(id)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(overview)
        parcel.writeValue(popularity)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeString(title)
        parcel.writeValue(video)
        parcel.writeValue(vote_average)
        parcel.writeValue(vote_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResult> {
        override fun createFromParcel(parcel: Parcel): MovieResult {
            return MovieResult(parcel)
        }

        override fun newArray(size: Int): Array<MovieResult?> {
            return arrayOfNulls(size)
        }
    }
}