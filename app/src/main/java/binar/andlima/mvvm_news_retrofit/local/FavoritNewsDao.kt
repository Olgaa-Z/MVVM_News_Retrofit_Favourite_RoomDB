package binar.andlima.mvvm_news_retrofit.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritNewsDao {

    @Insert
    fun addToFavorit(favoritNews : FavoritNews):Long

    @Query("SELECT * FROM FavoritNews")
    fun getFavoritNews() : List<FavoritNews>

//
    @Query("SELECT count(*) FROM FavoritNews WHERE FavoritNews.id = :id")
    fun checkNews(id: Int) : Int



//    @Query("DELETE FROM FavoritNews WHERE FavoritNews.id = :id")
//     fun removeFromFavorit(id :Int):Int


}

