package binar.andlima.mvvm_news_retrofit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.andlima.mvvm_news_retrofit.R
import binar.andlima.mvvm_news_retrofit.local.FavoritNews
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsFavAdapter(val newsdata : List<FavoritNews>): RecyclerView.Adapter<NewsFavAdapter.ViewHolder>() {

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFavAdapter.ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent,false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: NewsFavAdapter.ViewHolder, position: Int) {
        holder.itemView.tvTitle.text= newsdata!![position].title
        holder.itemView.tvDate.text = newsdata!![position].date
        holder.itemView.tvAuthor.text = newsdata!![position].author

        Glide.with(holder.itemView.context).load(newsdata!![position].image).into(holder.itemView.imgNews)

//        holder.itemView.cardNews.setOnClickListener {
//            onClick(newsdata!![position])
//        }
    }

    override fun getItemCount(): Int {
        return newsdata.size
    }
}