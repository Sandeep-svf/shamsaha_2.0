package com.sam.shamsaha.getinvolved;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentVolunteerBinding;

public class Volunteer extends Fragment {
    FragmentVolunteerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = FragmentVolunteerBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.crisisAdvocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CrisisAdvocate crisisAdvocate = new CrisisAdvocate();
                replace_fragment(crisisAdvocate);
            }
        });

        binding.otherOpprtunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manualcodePopup();
            }
        });

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetInvolved getInvolved = new GetInvolved();
                replace_fragment(getInvolved);
            }
        });






        return  view;
    }
    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
    private void manualcodePopup() {

        View customView = getLayoutInflater().inflate(R.layout.manualcode_layout, null);

        //   ImageView close_app_img = customView.findViewById(R.id.close_app_img);


        int height = 0;
        try {
            WindowManager wm = (WindowManager) customView.getContext().getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            height = wm.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PopupWindow popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.MATCH_PARENT, (int) (height * 1 / 1.14), true);
        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.showAtLocation(customView, Gravity.BOTTOM, 40, 60);

    }
}