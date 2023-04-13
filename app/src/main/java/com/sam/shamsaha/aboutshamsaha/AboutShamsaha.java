package com.sam.shamsaha.aboutshamsaha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.sam.shamsaha.R;


public class AboutShamsaha extends Fragment {

    WebView webView;
    // hhjkhkjh
    TextView jskljdfk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about_shamsaha, container, false);
        webView = view.findViewById(R.id.about_shamsaha_web_view);


        return view;
    }
}