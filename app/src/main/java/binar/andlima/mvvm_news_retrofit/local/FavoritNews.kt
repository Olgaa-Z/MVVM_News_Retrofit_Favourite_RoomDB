package binar.andlima.mvvm_news_retrofit.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class FavoritNews(

    @PrimaryKey
    val id : Int?,
    @ColumnInfo (name = "image")
    var image : String,
    @ColumnInfo (name = "title")
    var title : String,
    @ColumnInfo(name = "date")
    var date : String,
    @ColumnInfo(name = "author")
    var author : String
):Parcelable
