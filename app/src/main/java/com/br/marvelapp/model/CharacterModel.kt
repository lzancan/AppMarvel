package com.br.marvelapp.model

import android.os.Parcel
import android.os.Parcelable

class CharacterModel() : Parcelable {
    var id: Int = 0
    var name: String = ""
    var description: String = ""
    var thumbnail: ThumbnailObject? = null
    var comics: ComicModel? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString().toString()
        description = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterModel> {
        override fun createFromParcel(parcel: Parcel): CharacterModel {
            return CharacterModel(parcel)
        }

        override fun newArray(size: Int): Array<CharacterModel?> {
            return arrayOfNulls(size)
        }
    }

}