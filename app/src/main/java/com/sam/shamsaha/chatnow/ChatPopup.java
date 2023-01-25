package com.sam.shamsaha.chatnow;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentChatPopupBinding;


public class ChatPopup extends Fragment {

    FragmentChatPopupBinding binding;
    Animation animSlideIn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatPopupBinding.inflate(inflater,container,false);
        set_animation();
        binding.chatWholeCardViewLayout.setVisibility(View.VISIBLE);
        binding.askingNewUserWholeLayout.setVisibility(View.GONE);



        binding.internetEnglishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        binding.internetArbicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        binding.cellularEnglishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:1234546789" ));
                startActivity(intent);
            }
        });

        binding.cellularArbicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1234546789"));
                startActivity(intent);*/

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:1234546789" ));
                startActivity(intent);
            }
        });

        binding.yesButtonNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // chat now form fragment ...

                ChatNowForm fragment2 = new ChatNowForm();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment2);
                fragmentTransaction.commit();
            }
        });

        binding.cancelTalkNowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.askingNewUserWholeLayout.setVisibility(View.GONE);
                binding.chatWholeCardViewLayout.setVisibility(View.VISIBLE);
                set_animation();
            }
        });

        binding.chatEnglishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.askingNewUserWholeLayout.setVisibility(View.VISIBLE);
                binding.chatWholeCardViewLayout.setVisibility(View.GONE);
                set_animation_talk_now();




            }
        });

        binding.chatArbicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


       /* //popup
        final LayoutInflater inflater2 = getActivity().getLayoutInflater();
        View alertLayout = inflater2.inflate(R.layout.test_dialog_xml_otp, null);
        final ImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);
        final TextView error_message = alertLayout.findViewById(R.id.error_message);
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setView(alertLayout);
        alert.setCancelable(false);
        dialogs = alert.create();
        dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogs.show();
        dialogs.setCanceledOnTouchOutside(false);*/
        return binding.getRoot();


    }

    private void set_animation_talk_now() {
        animSlideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slid_in_right);
        binding.areYouNewUserText.setAnimation(animSlideIn);
        binding.yesNoTalkLayout.setAnimation(animSlideIn);
    }

    private void set_animation() {
        animSlideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_left);

        binding.chatCardViewLayout.setAnimation(animSlideIn);
        binding.internetCallCardViewLayout.setAnimation(animSlideIn);
        binding.cellularCallCardViewLayout.setAnimation(animSlideIn);

    }
}