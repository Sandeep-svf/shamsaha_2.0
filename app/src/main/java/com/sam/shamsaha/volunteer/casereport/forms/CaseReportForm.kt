package com.sam.shamsaha.volunteer.casereport.forms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.FragmentActivity
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentCaseReportFormBinding
import com.sam.shamsaha.utility.StaticKey


class CaseReportForm : Fragment() {

    private lateinit var binding : FragmentCaseReportFormBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentCaseReportFormBinding.inflate(inflater,container,false)
        val view = binding.root

         binding.apply {


        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        formsWebView.webViewClient = WebViewClient()

        // this will load the url of the website
             formsWebView.loadUrl(StaticKey.FORM_URL)

        // this will enable the javascript settings, it can also allow xss vulnerabilities
             formsWebView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
             formsWebView.settings.setSupportZoom(true)
         }
        return view;
    }


}