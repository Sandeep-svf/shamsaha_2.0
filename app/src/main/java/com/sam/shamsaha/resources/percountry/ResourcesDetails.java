package com.sam.shamsaha.resources.percountry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.databinding.FragmentResourcesDetailsBinding;
import com.sam.shamsaha.resources.percountry.adapter.PerCountryAdapter;
import com.sam.shamsaha.resources.percountry.adapter.ResourcesDetailsAdapter;


public class ResourcesDetails extends Fragment {


    FragmentResourcesDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResourcesDetailsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        binding.rcvResourcesDetials.setLayoutManager(linearLayoutManager);
        ResourcesDetailsAdapter obj = new ResourcesDetailsAdapter(getActivity());
        binding.rcvResourcesDetials.setAdapter(obj);


        binding.sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





        return  view;
    }
}