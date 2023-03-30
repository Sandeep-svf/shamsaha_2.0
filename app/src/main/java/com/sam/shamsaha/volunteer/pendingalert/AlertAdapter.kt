package com.sam.shamsaha.volunteer.pendingalert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.databinding.AlertListViewHolderBinding
import com.sam.shamsaha.databinding.CaseListViewHolderBinding

class AlertAdapter(val context : Context, val alertList : List<AlertListModel>) :
    RecyclerView.Adapter<AlertAdapter.AlertListViewHolderClass>() {

    inner class AlertListViewHolderClass(binding: AlertListViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertListViewHolderClass {
        val binding = AlertListViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlertListViewHolderClass(binding)



    }

    override fun onBindViewHolder(holder: AlertListViewHolderClass, position: Int) {
        with(holder){
            with(alertList[position]){

            }
        }
    }

    override fun getItemCount(): Int {
        return alertList.size
    }
}