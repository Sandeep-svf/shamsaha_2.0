package com.sam.shamsaha.volunteer.pastreport

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentPastReportBinding
import com.sam.shamsaha.volunteer.casereport.CaseReportAdapter
import com.sam.shamsaha.volunteer.casereport.CaseReportModel


class PastReport : Fragment() {

    lateinit var binding : FragmentPastReportBinding
    lateinit var pastReportAdapter: PastReportAdapter
    lateinit var pastReportList :  List<PastReportModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPastReportBinding.inflate(inflater,container,false)
        val view : View = binding.root
        load_case_report_list()



        // using recyler view
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rv list layout manager
        binding!!.rcvPastCaseReport.setLayoutManager(layoutManager)

        // initialized the obj and pass the req obj
        pastReportAdapter = PastReportAdapter(requireContext(), pastReportList)

        // attach adapter to the reycler view
        binding.rcvPastCaseReport.adapter = pastReportAdapter


        return view;
    }
    private fun load_case_report_list() {
        pastReportList = listOf(
            PastReportModel("CI001143","02 Oct 2023 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001144","02 Frb 2018 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001183","09 Jan 2020 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001753","15 Sept 2022 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001856","02 Dec 2015 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001143","02 Oct 2023 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001144","02 Frb 2018 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001183","09 Jan 2020 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001753","15 Sept 2022 06:18 PM",R.drawable.ic_launcher_background),
            PastReportModel("CI001856","02 Dec 2015 06:18 PM",R.drawable.ic_launcher_background),
        )
    }

}