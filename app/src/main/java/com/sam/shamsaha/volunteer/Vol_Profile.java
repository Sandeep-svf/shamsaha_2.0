package com.sam.shamsaha.volunteer;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;


public class Vol_Profile extends Fragment {



    AppCompatImageView contact_arrow_down, address_arrow_down,language_arrow_down;
    LinearLayoutCompat contact_hidden_layout,address_hidden_layout,language_hidden_layout;
    private Boolean contactLayoutFlag = true;
    private Boolean addressLayoutFlag = true;
    private Boolean languageLayoutFlag = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vol__profile, container, false);

        intis(view);



        language_arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(languageLayoutFlag){
                    languageLayoutFlag = false;
                    language_hidden_layout.setVisibility(View.VISIBLE);
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
                    }else{
                        contactLayoutFlag = true;
                        contact_hidden_layout.setVisibility(View.GONE);
                    }



            }
        });




        return view;
    }

    private void intis(View view) {
        contact_arrow_down = view.findViewById(R.id.contact_arrow_down);
        contact_hidden_layout = view.findViewById(R.id.contact_hidden_layout);
        contact_arrow_down = view.findViewById(R.id.contact_arrow_down);
        address_hidden_layout = view.findViewById(R.id.address_hidden_layout);
        address_arrow_down = view.findViewById(R.id.address_arrow_down);
        language_hidden_layout = view.findViewById(R.id.language_hidden_layout);
        language_arrow_down = view.findViewById(R.id.language_arrow_down);
    }
}