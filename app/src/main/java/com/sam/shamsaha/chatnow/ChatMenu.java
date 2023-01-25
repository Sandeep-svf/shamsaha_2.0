package com.sam.shamsaha.chatnow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentChatMenuBinding;

import java.util.zip.Inflater;


public class ChatMenu extends Fragment {

    FragmentChatMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatMenuBinding.inflate(inflater,container,false);



        return binding.getRoot();
    }
}