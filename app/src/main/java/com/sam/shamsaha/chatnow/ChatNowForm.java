package com.sam.shamsaha.chatnow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentChatNowFormBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class ChatNowForm extends Fragment {

    FragmentChatNowFormBinding binding;


    private List<String> yesNoList = new ArrayList<>();
    private List<String> issueType = new ArrayList<>();
    private String selectedCountryName;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentChatNowFormBinding.inflate(inflater,container,false);


       add_data_yes_no_list();
       add_data_issue_type_list();
       spin_18_inits();
       spin_call_back_inits();
       spin_issue_facing_inits();

        selectedCountryName = binding.spinCountryCode.getSelectedCountryName().toString();

        // Handler...









        binding.chatNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validation()){

                    // connecting chat to vol....
                    Intent intent = new Intent(getActivity(), VictimVolChatActivity.class);
                    startActivity(intent);


                }


            }
        });

       binding.spinIssueType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String item = binding.spinIssueType.getSelectedItem().toString();
               if (item.equals(getResources().getString(R.string.select_topic)))
               {

                   Log.e("test_sam_spin_18","0");

               }else if(item.equals(getResources().getString(R.string.yes)))
               {

                   Log.e("test_sam_spin_18","yes");

               }else if((item.equals(getResources().getString(R.string.no))))
               {
                   Log.e("test_sam_spin_18","n0");
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });








        binding.spinCallBack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = binding.spin18YearOld.getSelectedItem().toString();
                if (item.equals(getResources().getString(R.string.select_topic)))
                {

                    Log.e("test_sam_spin_18","0");

                }else if(item.equals(getResources().getString(R.string.yes)))
                {

                    Log.e("test_sam_spin_18","yes");

                }else if((item.equals(getResources().getString(R.string.no))))
                {
                    Log.e("test_sam_spin_18","n0");
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



       binding.spin18YearOld.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               String item = binding.spin18YearOld.getSelectedItem().toString();
               if (item.equals(getResources().getString(R.string.select_topic)))
               {

                   Log.e("test_sam_spin_18","0");

               }else if(item.equals(getResources().getString(R.string.yes)))
               {

                   Log.e("test_sam_spin_18","yes");

               }else if((item.equals(getResources().getString(R.string.no))))
               {
                   Log.e("test_sam_spin_18","n0");
               }


           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });



       return binding.getRoot();

    }




    private boolean validation() {

        if(binding.victimPhoneNumber.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void add_data_issue_type_list() {
        issueType.add("Physical");
        issueType.add("Sexual");
        issueType.add("Emotional");
        issueType.add("Other");
    }

    private void spin_issue_facing_inits() {

        spinnerAdapter dAdapter = new spinnerAdapter(getActivity(), R.layout.custom_spinner_two, issueType);
        dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dAdapter.addAll(issueType);
        dAdapter.add(getResources().getString(R.string.select_topic));
        binding.spinIssueType.setAdapter(dAdapter);
        binding.spinIssueType.setSelection(dAdapter.getCount());

    }



    private void spin_call_back_inits() {
        spinnerAdapter dAdapter = new spinnerAdapter(getActivity(), R.layout.custom_spinner_two, yesNoList);
        dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dAdapter.addAll(yesNoList);
        dAdapter.add(getResources().getString(R.string.select_topic));
        binding.spinCallBack.setAdapter(dAdapter);
        binding.spinCallBack.setSelection(dAdapter.getCount());
    }

    private void add_data_yes_no_list() {
        yesNoList.add("Yes");
        yesNoList.add("No");
    }

    private void spin_18_inits() {
        spinnerAdapter dAdapter = new spinnerAdapter(getActivity(), R.layout.custom_spinner_two, yesNoList);
        dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dAdapter.addAll(yesNoList);
        dAdapter.add(getResources().getString(R.string.select_topic));
        binding.spin18YearOld.setAdapter(dAdapter);
        binding.spin18YearOld.setSelection(dAdapter.getCount());
    }

    public class spinnerAdapter extends ArrayAdapter<String>
    {
        private spinnerAdapter(Context context, int textViewResourceId, List<String> smonking)
        {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount()
        {
            int count = super.getCount();
            return count > 0 ? count - 1 : count;
        }
    }
}
