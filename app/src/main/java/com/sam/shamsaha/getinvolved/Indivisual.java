package com.sam.shamsaha.getinvolved;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentIndivisualBinding;


public class Indivisual extends Fragment {

    FragmentIndivisualBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentIndivisualBinding.inflate(inflater,container,false);
       View view = binding.getRoot();

       binding.medicalSponser.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Medical medical = new Medical();
               replace_fragment(medical);

           }
       });

       binding.generalSponsor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               General general = new General();
               replace_fragment(general);

           }
       });




       return view;
    }
    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}