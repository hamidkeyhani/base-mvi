package com.base.common.utils

import android.os.Parcel
import android.os.Parcelable
import kotlinx.datetime.LocalDate

data class LocalDateWrapper(val localDate: LocalDate? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
        LocalDate.parse(parcel.readString().orEmpty())
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(localDate.toString())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LocalDateWrapper> {
        override fun createFromParcel(parcel: Parcel): LocalDateWrapper {
            return LocalDateWrapper(parcel)
        }

        override fun newArray(size: Int): Array<LocalDateWrapper?> {
            return arrayOfNulls(size)
        }
    }
}