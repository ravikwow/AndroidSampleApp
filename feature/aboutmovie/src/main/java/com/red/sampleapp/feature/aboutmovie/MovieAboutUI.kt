package com.red.sampleapp.feature.aboutmovie

import android.os.Parcel
import android.os.Parcelable

data class MovieAboutUI(
    val id: Long,
    val name: String = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieAboutUI> {
        override fun createFromParcel(parcel: Parcel): MovieAboutUI {
            return MovieAboutUI(parcel)
        }

        override fun newArray(size: Int): Array<MovieAboutUI?> {
            return arrayOfNulls(size)
        }
    }
}