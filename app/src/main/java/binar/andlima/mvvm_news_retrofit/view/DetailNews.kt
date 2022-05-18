package binar.andlima.mvvm_news_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.andlima.mvvm_news_retrofit.R
import binar.andlima.mvvm_news_retrofit.local.FavoritNews
import binar.andlima.mvvm_news_retrofit.local.FavoritNewsDao
import binar.andlima.mvvm_news_retrofit.local.NewsDatabase
import binar.andlima.mvvm_news_retrofit.model.getAllNews
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.coroutines.*

class DetailNews : AppCompatActivity() {
    private var newsDao : FavoritNewsDao?=null
    private var newsDb : NewsDatabase?=null
    private var id :Int?=null

    companion object{
        const val  EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        newsDb = NewsDatabase.getInstance(this)
        newsDao = newsDb?.newsDao()
        id = intent.getIntExtra(EXTRA_ID, 0)

        val detailnews = intent.getSerializableExtra("detailnews") as getAllNews?
        tvDetailjudul.text = detailnews?.title
        tvDetailAuthor.text = detailnews?.author
        tvDetailDate.text= detailnews?.createdAt
        tvDetailDescription.text = detailnews?.description
        Glide.with(this).load(detailnews?.image).into(imgDetail)


        toggleFavorit.setOnClickListener{
            GlobalScope.async {
                val d = intent.getSerializableExtra("detailnews") as getAllNews?
                val title = detailnews!!.title
                val idd = detailnews!!.id!!.toInt()
                val img = detailnews!!.image
                val date = detailnews!!.createdAt
                val author = detailnews!!.author
                val hasil = newsDb?.newsDao()?.addToFavorit(FavoritNews(idd,img,title,date,author))

                runOnUiThread {
                    if (hasil != 0.toLong()){
                        Toast.makeText(this@DetailNews, "Add to Favorit", Toast.LENGTH_LONG).show()
                        var _isChecked = false
                        _isChecked = !_isChecked
                        toggleFavorit.isChecked = _isChecked
                    }else{
                        Toast.makeText(this@DetailNews, "Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


//        toggleFavorit.setOnClickListener{
//            var _isChecked = false
//            _isChecked = !_isChecked
//            if (_isChecked){
//                addToFavorit(detailnews!!.id!!.toInt(), detailnews.image,detailnews.title,detailnews.createdAt,detailnews.author)
//
//            }
//            toggleFavorit.isChecked = _isChecked
//        }


    }

//    fun addToFavorit(id:Int, image:String,title:String, date:String, author:String){
//
//            var news = FavoritNews(
//                id,image,title,date,author
//            )
//            newsDao?.addToFavorit(news)
//
//    }

//    suspend fun checkUser(id:Int)= newsDao?.checkNews(id)
//
//    fun removeFromFavorit(id:Int){
//        CoroutineScope(Dispatchers.IO).launch {
//            newsDao?.removeFromFavorit(id)
//        }
//    }

//    fun checkToggle(){
//        var _isChecked = false
//        CoroutineScope(Dispatchers.IO).launch {
//            val count = checkUser(id!!)
//            withContext(Dispatchers.Main){
//                if (count != null){
//                    if (count > 0){
//                        toggleFavorit.isChecked = true
//                        _isChecked=true
//                    }else{
//                        toggleFavorit.isChecked = false
//                        _isChecked = false
//                    }
//                }
//            }
//        }
//
//        toggleFavorit.setOnClickListener{
//            val detailnews = intent.getSerializableExtra("detailnews") as getAllNews
//            val idd = detailnews.id.toInt()
//            val img = detailnews.image
//            val title = detailnews.title
//            val date = detailnews.createdAt
//            val author = detailnews.author
//
//            _isChecked = !_isChecked
//            if (_isChecked){
//                addToFavorit(idd,img,title,date,author)
//            }else{
//                removeFromFavorit(idd)
//            }
//
//            toggleFavorit.isChecked = _isChecked
//        }
//
//    }
}