package binar.andlima.mvvm_news_retrofit.network

import binar.andlima.mvvm_news_retrofit.model.getAllNews
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    @GET("news")
    fun getAllNews() : Call<List<getAllNews>>
}