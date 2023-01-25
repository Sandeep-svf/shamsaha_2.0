package com.sam.shamsaha.chatnow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentChatNowBinding;


public class ChatNow extends Fragment {


    FragmentChatNowBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentChatNowBinding.inflate(inflater,container,false);

       handler();




       return binding.getRoot();
    }

    private void handler() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(getActivity(), "Please wait ....", Toast.LENGTH_SHORT).show();
            }
        }, 5);  //  5 seconds
    }
}