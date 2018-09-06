package vn.musicstore.app.model

import android.os.Parcel
import android.os.Parcelable

open class BaseModel() : Parcelable {
    var Id:Long = 0

    constructor(parcel: Parcel) : this() {
        Id = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(Id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseModel> {
        override fun createFromParcel(parcel: Parcel): BaseModel {
            return BaseModel(parcel)
        }

        override fun newArray(size: Int): Array<BaseModel?> {
            return arrayOfNulls(size)
        }
    }

}