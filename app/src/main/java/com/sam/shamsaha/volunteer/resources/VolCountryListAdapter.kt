package com.sam.shamsaha.volunteer.resources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.databinding.SingleItemBinding

class VolCountryListAdapter(var volCountryLis: List<VolCountryListModel>,
    ) : RecyclerView.Adapter<VolCountryListAdapter.CountryViewHolder>() {


    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class CountryViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        with(holder){
            with(volCountryLis[position]){
                binding.serviceName.text = this.serviceName
            }
        }

    }

    override fun getItemCount(): Int {
        // return size of the list...
        return volCountryLis.size
    }


}