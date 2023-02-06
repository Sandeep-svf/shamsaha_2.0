package com.sam.shamsaha.volunteer.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentVolResourcesBinding

class VolResourcesFragment : Fragment() , AdapterView.OnItemSelectedListener {

    private var binding : FragmentVolResourcesBinding ? = null

    // create reference to the adapter and the list
    // in the list pass the model of Language
    /*** The “lateinit” keyword in Kotlin as the name suggests is used to declare those variables
     * that are guaranteed to be initialized in the future */
    private lateinit var volCountryListAdapter : VolCountryListAdapter
    private lateinit var volCountryList : List<VolCountryListModel>
    private lateinit var spinnerCountryList : List<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVolResourcesBinding.inflate(inflater, container, false)


        // load country list
        laod_country_list()
        laod_spine_country_list()

        /*** Usinng Recyler view */
        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rvLists layoutManager
        binding!!.rcvCountryList.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        volCountryListAdapter = VolCountryListAdapter(requireContext(),volCountryList)
        // attach adapter to the recycler view
        binding!!.rcvCountryList.adapter = volCountryListAdapter

        // Spinner ...

        binding!!.countrySpinner.onItemSelectedListener = this
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding!!.countrySpinner.adapter = adapter
        }




        // Inflate the layout for this fragment
        // added not null associate...
        return binding!!.root
    }
    private fun laod_spine_country_list() {
        spinnerCountryList = listOf("India","Ucrain","USA","china","Shree")
    }

    private fun laod_country_list() {
        // add data in country list model...

        volCountryList = listOf(
            VolCountryListModel("Java","2"),
            VolCountryListModel("C","5"),
            VolCountryListModel("Java","9"),
            VolCountryListModel("Java","10"),
            VolCountryListModel("Java","12")
        )

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        // getting stirng value form spinner ....
        val text: String = p0?.getItemAtPosition(p2).toString()

        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {


    }

}