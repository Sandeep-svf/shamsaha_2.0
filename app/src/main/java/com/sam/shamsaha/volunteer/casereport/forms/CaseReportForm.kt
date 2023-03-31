package com.sam.shamsaha.volunteer.casereport.forms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentCaseReportFormBinding


class CaseReportForm : Fragment() {

    private lateinit var binding : FragmentCaseReportFormBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentCaseReportFormBinding.inflate(inflater,container,false)
        val view = binding.root


        return view;
    }


}