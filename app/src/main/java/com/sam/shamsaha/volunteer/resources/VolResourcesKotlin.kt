package com.sam.shamsaha.volunteer.resources

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.ActivityVolResourcesKotlinBinding

class VolResourcesKotlin : AppCompatActivity() , AdapterView.OnItemSelectedListener {

    // view binding for the activity
    private lateinit var binding: ActivityVolResourcesKotlinBinding

    // create reference to the adapter and the list
    // in the list pass the model of Language
    private lateinit var volCountryListAdapter : VolCountryListAdapter
    private lateinit var volCountryList : List<VolCountryListModel>
    private lateinit var spinnerCountryList : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolResourcesKotlinBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // load country list
        laod_country_list()
        laod_spine_country_list()

        /*** Usinng Recyler view */
        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        // pass it to rvLists layoutManager
        binding.rcvCountryList.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        volCountryListAdapter = VolCountryListAdapter(volCountryList)
        // attach adapter to the recycler view
        binding.rcvCountryList.adapter = volCountryListAdapter



        // Spinner ...
        val spinner: Spinner = findViewById(R.id.country_spinner)
        spinner.onItemSelectedListener = this
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


    }

    private fun laod_spine_country_list() {
        spinnerCountryList = listOf("India","Ucrain","USA","china","Shree")
    }

    private fun laod_country_list() {
       // add data in country list model...

        volCountryList = listOf(


        )


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // on item selected from spinner ....


        // implement countries APIs...

        Log.e("test_sam_spin","On item selected..."+p0+p1+p2+p3)
    }



    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.e("test_sam_spin","On nothing selected..."+p0)
    }


}

