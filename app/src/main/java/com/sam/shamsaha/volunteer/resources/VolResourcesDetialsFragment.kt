package com.sam.shamsaha.volunteer.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentVolResourcesDetialsBinding


class VolResourcesDetialsFragment : Fragment() {

    private lateinit var binding  :  FragmentVolResourcesDetialsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVolResourcesDetialsBinding.inflate(inflater,container,false);
        val view = binding.root









        return  view;
    }

    override fun onDestroy() {
        super.onDestroy()

    }


}