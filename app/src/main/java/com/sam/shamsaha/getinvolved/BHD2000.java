package com.sam.shamsaha.getinvolved;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentBHD2000Binding;
import com.sam.shamsaha.databinding.FragmentBHD500Binding;
import com.sam.shamsaha.utility.StaticKey;


public class BHD2000 extends Fragment {

    FragmentBHD2000Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBHD2000Binding.inflate(inflater,container,false);
        View view = binding.getRoot();


        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticKey.sponsorKey = "1";
                Sponsor sponsor = new Sponsor();
                replace_fragment(sponsor);

            }
        });

        return view;
    }   private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}