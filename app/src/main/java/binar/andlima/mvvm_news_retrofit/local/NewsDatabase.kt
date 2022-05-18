package binar.andlima.mvvm_news_retrofit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritNews::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao() : FavoritNewsDao

    companion object{
        private var INSTANCE : NewsDatabase? = null

        fun getInstance(context : Context):NewsDatabase? {
            if (INSTANCE == null){
                synchronized(NewsDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NewsDatabase::class.java,"favoritnews.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}