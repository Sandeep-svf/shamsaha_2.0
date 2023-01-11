package com.sam.shamsaha.volunteer.dashboard;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.volunteer.Vol_Profile;


public class VolProfileEditable extends Fragment {


    AppCompatImageView back_arrow_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_vol_profile_editable, container, false);

        intis(view);

        back_arrow_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling fragment from fragment ...

                // replace fragment.....
                Vol_Profile fragment2 = new Vol_Profile();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_vol, fragment2);
                fragmentTransaction.commit();
            }
        });




        return view;
    }

    private void intis(View view) {
        back_arrow_image = view.findViewById(R.id.back_arrow_image);
    }
}