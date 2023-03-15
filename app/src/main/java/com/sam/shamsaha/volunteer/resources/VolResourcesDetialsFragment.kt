package com.sam.shamsaha.volunteer.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentVolResourcesDetialsBinding


class VolResourcesDetialsFragment : Fragment() {

    private lateinit var binding  :  FragmentVolResourcesDetialsBinding
    private lateinit var valDetailsList : List<ValDetailsModel>
    private lateinit var resourcesDetailsAdapter: ResourcesDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVolResourcesDetialsBinding.inflate(inflater,container,false);
        val view = binding.root

        /*** Usinng Recyler view */
        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rvLists layoutManager
        binding!!.rcvResourcesDetails.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        resourcesDetailsAdapter = ResourcesDetailsAdapter(requireContext(),valDetailsList)
        // attach adapter to the recycler view
        binding!!.rcvResourcesDetails.adapter = resourcesDetailsAdapter









        return  view;
    }

    override fun onDestroy() {
        super.onDestroy()

    }


}