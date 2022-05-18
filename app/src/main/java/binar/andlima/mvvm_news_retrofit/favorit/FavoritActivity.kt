package binar.andlima.mvvm_news_retrofit.favorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.andlima.mvvm_news_retrofit.R
import binar.andlima.mvvm_news_retrofit.local.NewsDatabase
import binar.andlima.mvvm_news_retrofit.model.getAllNews
import binar.andlima.mvvm_news_retrofit.view.NewsAdapter
import binar.andlima.mvvm_news_retrofit.view.NewsFavAdapter
import binar.andlima.mvvm_news_retrofit.viewmodel.FavoritViewModel
import binar.andlima.mvvm_news_retrofit.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_favorit.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoritActivity : AppCompatActivity() {

    private var mDBnew : NewsDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorit)

        mDBnew = NewsDatabase.getInstance(this)

        getDataStudent()

    }


    fun getDataStudent(){

        rvFavNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        GlobalScope.launch {
            val listdata = mDBnew?.newsDao()?.getFavoritNews()
            runOnUiThread {
                listdata.let {
                    val adapt = NewsFavAdapter(it!!)
                    rvFavNews.adapter = adapt
                }
            }
        }

    }


}