package com.sam.shamsaha.getinvolved;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentCorporateBinding;


public class Corporate extends Fragment {

    FragmentCorporateBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCorporateBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.bhd500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BHD500 sponsor = new BHD500();
                replace_fragment(sponsor);

            }
        });

        binding.bhd1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BHD1000 sponsor = new BHD1000();
                replace_fragment(sponsor);
            }
        });

        binding.bhd2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BHD2000 sponsor = new BHD2000();
                replace_fragment(sponsor);
            }
        });

        binding.additionalOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdditonalOption sponsor = new AdditonalOption();
                replace_fragment(sponsor);
            }
        });


        return view;
    }  private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}