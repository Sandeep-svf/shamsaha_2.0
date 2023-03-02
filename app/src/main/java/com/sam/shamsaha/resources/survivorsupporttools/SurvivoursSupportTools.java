package com.sam.shamsaha.resources.survivorsupporttools;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentSurvivoursSupportToolsBinding;
import com.sam.shamsaha.resources.percountry.adapter.ResourcesDetailsAdapter;
import com.sam.shamsaha.resources.survivorsupporttools.adapter.SSTAdaptor;


public class SurvivoursSupportTools extends Fragment {


    FragmentSurvivoursSupportToolsBinding binding;
    private int numberOfColumns = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSurvivoursSupportToolsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        binding.rcvSst.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        SSTAdaptor  sstAdaptor = new SSTAdaptor(getActivity());
        binding.rcvSst.setAdapter(sstAdaptor);



        return view;
    }
}