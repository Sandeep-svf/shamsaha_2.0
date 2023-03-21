package com.sam.shamsaha.volunteer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.volunteer.dashboard.VolProfileEditable;

import butterknife.BindView;


public class Vol_Profile extends Fragment {



    AppCompatImageView contact_arrow_down, address_arrow_down,language_arrow_down,date_arrow_down;
    AppCompatImageView edit_vol_profile_image;
    AppCompatTextView vol_name;


    LinearLayoutCompat contact_hidden_layout,address_hidden_layout,language_hidden_layout,date_hidden_layout;
    private Boolean contactLayoutFlag = true;
    private Boolean addressLayoutFlag = true;
    private Boolean languageLayoutFlag = true;
    private Boolean dateLayoutFlag = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vol__profile, container, false);

        intis(view);





        edit_vol_profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace fragment.....
                VolProfileEditable fragment2 = new VolProfileEditable();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_vol, fragment2);
                fragmentTransaction.commit();
            }
        });

        date_arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dateLayoutFlag){
                    dateLayoutFlag = false;
                    date_hidden_layout.setVisibility(View.VISIBLE);
                    contact_hidden_layout.setVisibility(View.GONE);
                    language_hidden_layout.setVisibility(View.GONE);
                    address_hidden_layout.setVisibility(View.GONE);
                    contactLayoutFlag = true;
                    languageLayoutFlag = true;
                    addressLayoutFlag = true;

                }else{
                    dateLayoutFlag = true;
                    date_hidden_layout.setVisibility(View.GONE);
                }
            }
        });

        language_arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(languageLayoutFlag){
                    languageLayoutFlag = false;
                    language_hidden_layout.setVisibility(View.VISIBLE);
                    contact_hidden_layout.setVisibility(View.GONE);
                    address_hidden_layout.setVisibility(View.GONE);
                    date_hidden_layout.setVisibility(View.GONE);
                    contactLayoutFlag = true;
                    dateLayoutFlag = true;
                    addressLayoutFlag = true;
                }else{
                    languageLayoutFlag = true;
                    language_hidden_layout.setVisibility(View.GONE);
                }
            }
        });

        address_arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addressLayoutFlag){
                    addressLayoutFlag = false;
                    address_hidden_layout.setVisibility(View.VISIBLE);
                    contact_hidden_layout.setVisibility(View.GONE);
                    language_hidden_layout.setVisibility(View.GONE);
                    date_hidden_layout.setVisibility(View.GONE);
                    contactLayoutFlag = true;
                    languageLayoutFlag = true;
                    dateLayoutFlag = true;
                }else{
                    addressLayoutFlag = true;
                    address_hidden_layout.setVisibility(View.GONE);
                }
            }
        });

        contact_arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("test_sam_arrow_down","clicked");


                    if(contactLayoutFlag){
                        contactLayoutFlag = false;
                        contact_hidden_layout.setVisibility(View.VISIBLE);
                        address_hidden_layout.setVisibility(View.GONE);
                        language_hidden_layout.setVisibility(View.GONE);
                        date_hidden_layout.setVisibility(View.GONE);
                        dateLayoutFlag = true;
                        languageLayoutFlag = true;
                        addressLayoutFlag = true;
                    }else{
                        contactLayoutFlag = true;
                        contact_hidden_layout.setVisibility(View.GONE);
                    }

            }
        });


        return view;
    }

    private void intis(View view) {
        vol_name = view.findViewById(R.id.vol_name);
        edit_vol_profile_image = view.findViewById(R.id.edit_vol_profile_image);
        date_arrow_down = view.findViewById(R.id.date_arrow_down);
        contact_arrow_down = view.findViewById(R.id.contact_arrow_down);
        contact_hidden_layout = view.findViewById(R.id.contact_hidden_layout);
        contact_arrow_down = view.findViewById(R.id.contact_arrow_down);
        address_hidden_layout = view.findViewById(R.id.address_hidden_layout);
        address_arrow_down = view.findViewById(R.id.address_arrow_down);
        language_hidden_layout = view.findViewById(R.id.language_hidden_layout);
        language_arrow_down = view.findViewById(R.id.language_arrow_down);
        date_hidden_layout = view.findViewById(R.id.date_hidden_layout);

    }
}