package com.sam.shamsaha.getinvolved;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentGetInvolvedBinding;
import com.sam.shamsaha.utility.UtilFun;


public class GetInvolved extends Fragment {

    ConstraintLayout voulnteerLayout,sponserLayout,workWithUsLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_involved, container, false);

        intis(view);

        voulnteerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace fragment .....
                Volunteer detailsFragment = new Volunteer();
                replace_fragment(detailsFragment);

            }
        });

        sponserLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sponsor sponsor = new Sponsor();
                replace_fragment(sponsor);

            }
        });

        workWithUsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Workwithus workwithus = new Workwithus();
                replace_fragment(workwithus);

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

    private void intis(View view) {

        voulnteerLayout = view.findViewById(R.id.voulnteer_layout);
        sponserLayout = view.findViewById(R.id.sponser_layout);
        workWithUsLayout = view.findViewById(R.id.work_with_us_layout);
    }


}