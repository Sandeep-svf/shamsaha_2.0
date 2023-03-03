package com.sam.shamsaha.volunteer.resources

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.SingleItemBinding
import com.sam.shamsaha.eventsmedia.EventDetails
import com.sam.shamsaha.utility.OnClickListener
import com.sam.shamsaha.utility.UtilFun

class VolCountryListAdapter(
    var context: Context, var volCountryLis: List<VolCountryListModel>,
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

        Log.e("test_sam_resources","A")

        with(holder){
            with(volCountryLis[position]){
                binding.serviceName.text = this.serviceName


                holder.itemView.setOnClickListener(View.OnClickListener {it: View->
                    var itemPosition : String = position.toString()

                    // changing fragment ...
                    val activity =it.context as FragmentActivity
                    val volResourcesFragment = VolResourcesDetialsFragment()
                    UtilFun.replaceFragmentVol(activity,volResourcesFragment)

                })

            }

        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragment.childFragmentManager.beginTransaction()
        transaction.replace(R.id.container_vol, fragment)
        transaction.commit()



    }




    override fun getItemCount(): Int {
        // return size of the list...
        return volCountryLis.size
    }


}