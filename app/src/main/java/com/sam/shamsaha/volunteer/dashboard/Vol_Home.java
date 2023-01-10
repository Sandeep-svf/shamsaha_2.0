package com.sam.shamsaha.volunteer.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.shamsaha.R;
import com.sam.shamsaha.volunteer.adapter.AnnouncementListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Vol_Home extends Fragment {



    RecyclerView rcv_announcement_list;

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





        return view;
    }

    private void intis(View view) {
        rcv_announcement_list = view.findViewById(R.id.rcv_announcement_list);
    }
}