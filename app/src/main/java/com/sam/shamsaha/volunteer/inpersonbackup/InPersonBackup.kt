package com.sam.shamsaha.volunteer.inpersonbackup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentInPersonBackupBinding

class InPersonBackup : Fragment() {


    lateinit var binding : FragmentInPersonBackupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInPersonBackupBinding.inflate(inflater,container,false)
        val view : View = binding.root




        return view
    }

}