package com.sam.shamsaha.volunteer.pendingalert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentAcceptPendingAlertBinding
import com.sam.shamsaha.volunteer.casereport.CaseReportAdapter


class AcceptPendingAlert : Fragment() {

    lateinit var binding : FragmentAcceptPendingAlertBinding
    lateinit var alertList : List<AlertListModel>
    lateinit var alertAdapter: AlertAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAcceptPendingAlertBinding.inflate(inflater,container,false)
        val view : View = binding.root

        //load data in alertlist
        load_data()


        // adapter
        // using recyler view
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rv list layout manager
        binding!!.rcvAlertList.setLayoutManager(layoutManager)

        // initialized the obj and pass the req obj
        alertAdapter = AlertAdapter(requireContext(), alertList)

        // attach adapter to the reycler view
        binding.rcvAlertList.adapter = alertAdapter


        return view;
    }

    private fun load_data() {
        alertList = listOf(
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available"),
            AlertListModel("abc","android studio electric eel 2022.1.1 path available")
        )
    }


}