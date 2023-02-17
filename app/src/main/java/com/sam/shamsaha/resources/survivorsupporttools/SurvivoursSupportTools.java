package com.sam.shamsaha.resources.survivorsupporttools;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentSurvivoursSupportToolsBinding;
import com.sam.shamsaha.resources.percountry.adapter.ResourcesDetailsAdapter;


public class SurvivoursSupportTools extends Fragment {


    FragmentSurvivoursSupportToolsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSurvivoursSupportToolsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        binding.rcvSst.setLayoutManager(linearLayoutManager);
        ResourcesDetailsAdapter obj = new ResourcesDetailsAdapter(getActivity());
        binding.rcvSst.setAdapter(obj);
        // dsfkjsjdfjkl

        return view;
    }
}