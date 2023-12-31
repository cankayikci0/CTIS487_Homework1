package additional_package

import android.os.Parcel
import android.os.Parcelable

class MovieReview(var name: String) : Parcelable{
    // Member properties
    var storyTelling: Int = 0
    var cinematography: Int = 0
    var acting: Int = 0



    // Primary constructor
    constructor(name: String, storyTelling: Int, cinematography: Int, acting: Int) : this(name) {
        this.storyTelling = storyTelling
        this.cinematography = cinematography
        this.acting = acting
    }

    // Member method
    fun displayReview() {
        println("Movie: $name")
        println("User Review Categories:")
        println("Category 1: $storyTelling")
        println("Category 2: $cinematography")
        println("Category 3: $acting")
    }

    // Static member

    protected constructor(`in`: Parcel) : this(`in`.readString() ?: "") {
        storyTelling = `in`.readInt()
        cinematography = `in`.readInt()
        acting = `in`.readInt()
    }
    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeInt(storyTelling)
        parcel.writeInt(cinematography)
        parcel.writeInt(acting)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<MovieReview> {

        const val COMMON_SCORE = 55
        override fun createFromParcel(parcel: Parcel): MovieReview {
            return MovieReview(parcel)
        }
        fun getDefaultMovieReview(point: Double): String {
            return if (point > COMMON_SCORE) "It Is a Great Film" else "It Is not a Great Film"
        }
        override fun newArray(size: Int): Array<MovieReview?> {
            return arrayOfNulls(size)
        }
    }
}
