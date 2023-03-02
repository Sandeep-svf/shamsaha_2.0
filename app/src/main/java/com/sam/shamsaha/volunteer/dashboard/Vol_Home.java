package com.sam.shamsaha.volunteer.dashboard;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.eventsmedia.EventDetails;
import com.sam.shamsaha.volunteer.adapter.AnnouncementListAdapter;
import com.sam.shamsaha.volunteer.casereport.CaseReport;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Vol_Home extends Fragment {



    RecyclerView rcv_announcement_list;
    ConstraintLayout case_report_layout_vol_dashboard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vol__home, container, false);

        intis(view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rcv_announcement_list.setLayoutManager(linearLayoutManager);
        AnnouncementListAdapter announcementListAdapter = new AnnouncementListAdapter(getActivity());
        rcv_announcement_list.setAdapter(announcementListAdapter);


        case_report_layout_vol_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling fragment
                CaseReport caseReport = new CaseReport();
                replace_fragment(caseReport);

            }
        });


        return view;
    }
    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_vol,fragment);
        fragmentTransaction.commit();
    }

    private void intis(View view) {
        rcv_announcement_list = view.findViewById(R.id.rcv_announcement_list);
        case_report_layout_vol_dashboard = view.findViewById(R.id.case_report_layout_vol_dashboard);
    }
}