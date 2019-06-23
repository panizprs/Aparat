package com.acm.workshop.aparat.app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acm.workshop.aparat.R
import com.acm.workshop.aparat.data.entity.VideoEntity

class HomeAdapter(private val items: List<VideoEntity>)  : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_video_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(video : VideoEntity){

        }

    }
}

