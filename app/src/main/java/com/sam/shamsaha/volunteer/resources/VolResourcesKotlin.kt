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

class VolResourcesKotlin : AppCompatActivity() {

    // view binding for the activity
    private lateinit var binding: ActivityVolResourcesKotlinBinding

    // create reference to the adapter and the list
    // in the list pass the model of Language
    private lateinit var volCountryListAdapter : VolCountryListAdapter
    private lateinit var volCountryList : List<VolCountryListModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolResourcesKotlinBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // load country list
        laod_country_list()

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

    private fun laod_country_list() {
       // add data in country list model...

        volCountryList = listOf(


        )


    }


}

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Log.e("test_sam_spin","On item selected..."+pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
        Log.e("test_sam_spin","On nothing selected...")
    }
}