package com.sam.shamsaha.volunteer.upcomingchat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.sam.shamsaha.databinding.UpcomingChatViewHolderBinding


class UpcomingChatAdapter (var context : Context, var upcomingChatList : List<UpcomingChatModel>) :
    RecyclerView.Adapter<UpcomingChatAdapter.UpcomingChatViewHolder>(){


    inner class UpcomingChatViewHolder(val binding : UpcomingChatViewHolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingChatViewHolder {
       val binding = UpcomingChatViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UpcomingChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingChatViewHolder, position: Int) {


        with((holder)){
            with(upcomingChatList[position]){
                binding.caseidTv.text = this.name
                binding.timetv.text = this.dateTime

                Glide.with(context).load(this.image).into(binding.imagecase)
            }
        }
    }

    override fun getItemCount(): Int {
     return upcomingChatList.size
    }
}