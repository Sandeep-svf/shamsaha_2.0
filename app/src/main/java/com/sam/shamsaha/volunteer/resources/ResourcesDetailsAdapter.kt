package com.sam.shamsaha.volunteer.resources

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.sam.shamsaha.databinding.ValresourcesdetailsBinding

class ResourcesDetailsAdapter(val context: Context, val resultDetailsList: List<ValDetailsModel>,):
    RecyclerView.Adapter
    <ResourcesDetailsAdapter.ResourceDetailsViewHolder>() {


    inner class ResourceDetailsViewHolder(val binding : ValresourcesdetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceDetailsViewHolder {

    }

    override fun onBindViewHolder(holder: ResourceDetailsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10;
    }

}