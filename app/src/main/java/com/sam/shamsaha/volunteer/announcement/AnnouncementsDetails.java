package com.sam.shamsaha.volunteer.announcement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentAnnouncementsDetailsBinding;


public class AnnouncementsDetails extends Fragment {


    FragmentAnnouncementsDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnnouncementsDetailsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();




        return view;
    }
}