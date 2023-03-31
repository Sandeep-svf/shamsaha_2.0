package com.sam.shamsaha.volunteer.announcement;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sam.shamsaha.R;

import com.sam.shamsaha.databinding.FragmentVolunteerAnnouncementsBinding;
import com.sam.shamsaha.volunteer.adapter.AnnouncementListAdapter;


public class VolunteerAnnouncements extends Fragment {

    FragmentVolunteerAnnouncementsBinding binding;
    AnnouncementListAdapter announcementListAdapter;
    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentVolunteerAnnouncementsBinding.inflate(inflater,container,false);
       View view = binding.getRoot();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        binding.rcvAnnouncementList.setLayoutManager(linearLayoutManager);
        announcementListAdapter = new AnnouncementListAdapter(getActivity());
        binding.rcvAnnouncementList.setAdapter(announcementListAdapter);


        binding.addAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // popup form
                // add announcement by volunteer ( show in list after update by admin)
                openDialog(getActivity());
            }
        });

       return view;
    }

    public void openDialog(Context context) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.add_announcemnt);
        ImageView i = dialog.findViewById(R.id.closeBtn2);
        AppCompatEditText description = dialog.findViewById(R.id.description_add_announcements);
        AppCompatEditText title = dialog.findViewById(R.id.title_add_announcement);
        AppCompatButton button = dialog.findViewById(R.id.add_announcement_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){
                    title.setText("");
                    description.setText("");
                    Toast.makeText(getActivity(), getResources().getString(R.string.record_submitted_successfully), Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            }

            private boolean validation() {
                if(title.getText().toString().equals("")){
                    Toast.makeText(context, getResources().getString(R.string.please_enter_title), Toast.LENGTH_SHORT).show();
                    return false;
                }else if(description.getText().toString().equals("")){
                    Toast.makeText(context, getResources().getString(R.string.please_enter_description), Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });

        //   hitApi(context,webView,progressBar);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
    }


}