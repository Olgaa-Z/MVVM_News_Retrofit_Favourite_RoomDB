package binar.andlima.mvvm_news_retrofit.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.andlima.mvvm_news_retrofit.local.FavoritNews
import binar.andlima.mvvm_news_retrofit.local.FavoritNewsDao
import binar.andlima.mvvm_news_retrofit.local.NewsDatabase
import binar.andlima.mvvm_news_retrofit.model.getAllNews

class FavoritViewModel(context: Context): ViewModel(){

    private var newsfavDao : FavoritNewsDao?=null
    private var newsfavDb : NewsDatabase?=null


    lateinit var liveDataListfav: MutableLiveData<List<FavoritNews>>

    init {
        newsfavDb = NewsDatabase.getInstance(context)
        newsfavDao = newsfavDb!!.newsDao()
    }


    fun getliveDataNewsfav(): MutableLiveData<List<FavoritNews>>{
        return  liveDataListfav
    }



}