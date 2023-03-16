package com.sam.shamsaha.volunteer.resources

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.databinding.SingleItemBinding

class ResourcesDetailsAdapter(val context: Context, val resultDetailsList: List<ValDetailsModel>,):
    RecyclerView.Adapter
    <ResourcesDetailsAdapter.ResourceDetailsViewHolder>() {


    inner class ResourceDetailsViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceDetailsViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResourceDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResourceDetailsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10;
    }

}