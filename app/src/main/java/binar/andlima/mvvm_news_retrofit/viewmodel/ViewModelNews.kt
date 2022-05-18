package binar.andlima.mvvm_news_retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.andlima.mvvm_news_retrofit.model.getAllNews
import binar.andlima.mvvm_news_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<getAllNews>>
    init {
        liveDataList = MutableLiveData()
    }

    fun getliveDataNews(): MutableLiveData<List<getAllNews>>{
        return  liveDataList
    }

    fun getDataNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<getAllNews>>{
                override fun onResponse(
                    call: Call<List<getAllNews>>,
                    response: Response<List<getAllNews>>
                ) {
                    if (response.isSuccessful){
                        liveDataList.postValue(response.body())
                    }else{
                        liveDataList.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllNews>>, t: Throwable) {
                    liveDataList.postValue(null)
                }

            })
    }
}