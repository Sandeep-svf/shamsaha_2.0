package com.sam.shamsaha.volunteer.dashboard;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.tabs.TabLayout;
import com.sam.shamsaha.R;
import com.sam.shamsaha.eventsmedia.EventDetails;
import com.sam.shamsaha.volunteer.Vol_Profile;
import com.sam.shamsaha.volunteer.adapter.AnnouncementListAdapter;
import com.sam.shamsaha.volunteer.casereport.CaseReport;
import com.sam.shamsaha.volunteer.resources.VolResourcesFragment;
import com.sam.shamsaha.volunteer.upcomingchat.CaseReportVolHomeList;
import com.sam.shamsaha.volunteer.upcomingchat.UpcomingChat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Vol_Home extends Fragment {



    RecyclerView rcv_common_vol_list_data;
    ConstraintLayout case_report_layout_vol_dashboard,vol_home_resources;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    AppCompatTextView availability_text;
    SwitchMaterial switch_avabililty;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vol__home, container, false);

        intis(view);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(viewPager,adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabtitle();



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rcv_common_vol_list_data.setLayoutManager(linearLayoutManager);
        AnnouncementListAdapter announcementListAdapter = new AnnouncementListAdapter(getActivity());
        rcv_common_vol_list_data.setAdapter(announcementListAdapter);


        switch_avabililty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switch_avabililty.isChecked()){
                    availability_text.setText(getResources().getString(R.string.available));
                }else{
                    availability_text.setText(getResources().getString(R.string.unavailable));
                }
            }
        });

        vol_home_resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vol_Profile vol_profile = new Vol_Profile();
                replace_fragment(vol_profile);
            }
        });

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
        rcv_common_vol_list_data = view.findViewById(R.id.rcv_common_vol_list_data);
        viewPager = view.findViewById(R.id.viewPager);
        switch_avabililty = view.findViewById(R.id.switch_avabililty);
        availability_text = view.findViewById(R.id.availability_text);
        tabLayout = view.findViewById(R.id.tab_layout);
        vol_home_resources = view.findViewById(R.id.vol_home_resources);
        case_report_layout_vol_dashboard = view.findViewById(R.id.case_report_layout_vol_dashboard);
    }
    private void setupTabtitle() {


        tabLayout.getTabAt(0).setText(getResources().getString(R.string.upcoming));

        tabLayout.getTabAt(1).setText(getResources().getString(R.string.previous));


    }
    public static void setupViewPager(ViewPager viewPager, ViewPagerAdapter adapter)
    {
        {
            adapter.addFragment(new UpcomingChat());
            adapter.addFragment(new CaseReportVolHomeList());

        }

        viewPager.setAdapter(adapter);
    }
    static class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);


        }


    }
}