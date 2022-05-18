package binar.andlima.mvvm_news_retrofit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.andlima.mvvm_news_retrofit.R
import binar.andlima.mvvm_news_retrofit.local.FavoritNews
import binar.andlima.mvvm_news_retrofit.model.getAllNews
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter(private var onClick : (getAllNews)->Unit): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsdata : List<getAllNews>? = null
    private var newsdatafav : List<FavoritNews>? = null
    fun setNewsList(newsList : List<getAllNews>){
        this.newsdata = newsList
    }

    fun setNewsListfav(newsList : List<FavoritNews>){
        this.newsdatafav = newsList
    }

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.itemView.tvTitle.text= newsdata!![position].title
        holder.itemView.tvDate.text = newsdata!![position].createdAt
        holder.itemView.tvAuthor.text = newsdata!![position].author

        Glide.with(holder.itemView.context).load(newsdata!![position].image).into(holder.itemView.imgNews)

        holder.itemView.cardNews.setOnClickListener {
            onClick(newsdata!![position])
        }
    }

    override fun getItemCount(): Int {
//        return newsdata.size
        if (newsdata == null){
            return 0
        }else{
            return newsdata!!.size
        }
    }
}