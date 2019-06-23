package com.acm.workshop.aparat.app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acm.workshop.aparat.R
import com.acm.workshop.aparat.data.entity.VideoEntity
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class HomeAdapter()  : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    private var items =  mutableListOf<VideoEntity>()
    fun setItems(newItems: List<VideoEntity>){
        items = newItems.toMutableList()
        notifyDataSetChanged()
    }

    fun addItems(newItems: List<VideoEntity>){
        val prvSize = items.size
        items.addAll(newItems)
        notifyItemRangeChanged(prvSize, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_video_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private val title = itemView.findViewById<TextView>(R.id.title)
        private val duraion = itemView.findViewById<TextView>(R.id.duration)

        private val image = itemView.findViewById<ImageView>(R.id.image)


        fun bind(video : VideoEntity){
            title.text = video.title
            duraion.text = video.duration
            Picasso.get().load(video.profilePhoto).into(image)
        }

    }
}

