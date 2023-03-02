package com.sam.shamsaha.volunteer.casereport

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentCaseReportBinding
import com.sam.shamsaha.databinding.FragmentVolResourcesDetialsBinding

class CaseReport : Fragment() {

    lateinit var binding: FragmentCaseReportBinding
    lateinit var caseReportAdapter: CaseReportAdapter
    lateinit var caseReportList :  List<CaseReportModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentCaseReportBinding.inflate(inflater,container,false)
        val view : View = binding.root

        load_case_report_list()

        // using recyler view
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rv list layout manager
        binding!!.rcvCaseReport.setLayoutManager(layoutManager)

        // initialized the obj and pass the req obj
        caseReportAdapter = CaseReportAdapter(requireContext(), caseReportList)

        // attach adapter to the reycler view
        binding.rcvCaseReport.adapter = caseReportAdapter


        return view
    }

    private fun load_case_report_list() {
       caseReportList = listOf(
           CaseReportModel("CI001143","02 Oct 2023 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001144","02 Frb 2018 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001183","09 Jan 2020 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001753","15 Sept 2022 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001856","02 Dec 2015 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001143","02 Oct 2023 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001144","02 Frb 2018 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001183","09 Jan 2020 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001753","15 Sept 2022 06:18 PM",R.drawable.ic_launcher_background),
           CaseReportModel("CI001856","02 Dec 2015 06:18 PM",R.drawable.ic_launcher_background),
       )
    }


}