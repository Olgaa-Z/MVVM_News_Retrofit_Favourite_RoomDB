package binar.andlima.mvvm_news_retrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.andlima.mvvm_news_retrofit.R
import binar.andlima.mvvm_news_retrofit.favorit.FavoritActivity
import binar.andlima.mvvm_news_retrofit.model.getAllNews
import binar.andlima.mvvm_news_retrofit.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter = NewsAdapter(){}

        rvNews.layoutManager = LinearLayoutManager(this)
        newsAdapter= NewsAdapter(){
            val pindahdata = Intent(applicationContext, DetailNews::class.java)
            pindahdata.putExtra("detailnews", it)
            pindahdata.putExtra(DetailNews.EXTRA_ID, it.id)
            startActivity(pindahdata)
        }
        rvNews.adapter = newsAdapter

        initViewModel()

        iconFav.setOnClickListener {
            startActivity(Intent(this, FavoritActivity::class.java))
        }
    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getliveDataNews().observe(this, Observer {
            if (it != null){
               newsAdapter.setNewsList(it)
               newsAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getDataNews()
    }

}
