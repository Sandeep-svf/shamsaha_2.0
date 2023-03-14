package com.sam.shamsaha.volunteer.onduitybackup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentLanguageBackupBinding


class LanguageBackup : Fragment() {


    lateinit var binding :  FragmentLanguageBackupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLanguageBackupBinding.inflate(inflater,container,false)
        val view : View = binding.root







        return view
    }


}