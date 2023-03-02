package com.sam.shamsaha.eventsmedia;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sam.shamsaha.R;
import com.sam.shamsaha.databinding.FragmentEventMediaBinding;
import com.sam.shamsaha.databinding.FragmentVolunteerBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class EventMedia extends Fragment {

    FragmentEventMediaBinding binding;
    private RunWizardAdapter myadapter;
    CircleIndicator banner_indicator;
    private TextView[] mdots;


    // on page scroll in view pager
    int SCROLLING_RIGHT = 0;
    int SCROLLING_LEFT = 1;
    int SCROLLING_UNDETERMINED = 2;
    int currentScrollDirection = 2;
    private int addDotNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEventMediaBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        List<RunWizardListModel> runWizardListModelList = new ArrayList<>();

        // add data in model manually
        RunWizardListModel runWizardListModel = new RunWizardListModel();
        runWizardListModel.setImage(R.drawable.ic_launcher_background);
        runWizardListModel.setName(getResources().getString(R.string.welcome_to_the_shamsha_application));
        runWizardListModelList.add(runWizardListModel);

        runWizardListModel = new RunWizardListModel();
        runWizardListModel.setImage(R.drawable.ic_launcher_background);
        runWizardListModel.setName(getResources().getString(R.string.welcome_to_the_shamsha_application));
        runWizardListModelList.add(runWizardListModel);

        runWizardListModel = new RunWizardListModel();
        runWizardListModel.setImage(R.drawable.ic_launcher_background);
        runWizardListModel.setName(getResources().getString(R.string.welcome_to_the_shamsha_application));
        runWizardListModelList.add(runWizardListModel);


        myadapter=new RunWizardAdapter(getActivity(),runWizardListModelList);
        binding.viewpager.setAdapter(myadapter);
        binding.bannerIndicator.setViewPager(binding.viewpager);

        addDotNumber = runWizardListModelList.size();

        adddots(0);

        binding.viewpager.addOnPageChangeListener(viewlistener);




        return view;
    }
    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            adddots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public void adddots(int i){


        mdots=new TextView[addDotNumber];
        binding.liner.removeAllViews();

        for (int x=0;x<mdots.length;x++){

            mdots[x]=new TextView(getActivity());
            mdots[x].setText(Html.fromHtml("&#8226;"));
            mdots[x].setTextSize(35);
            mdots[x].setTextColor(getResources().getColor(R.color.white));

            binding.liner.addView(mdots[x]);
        }
        if (mdots.length>0){

            mdots[i].setTextColor(getResources().getColor(R.color.white));

        }

    }
    private void setScrollingDirection(float positionOffset){
        if ((1-positionOffset)>= 0.5){
            this.currentScrollDirection = SCROLLING_RIGHT;
        }
        else if ((1-positionOffset)<= 0.5){
            this.currentScrollDirection =  SCROLLING_LEFT;
        }
    }

    private boolean isScrollingRight(){
        return currentScrollDirection == SCROLLING_RIGHT;
    }

    private boolean isScrollingLeft(){
        return currentScrollDirection == SCROLLING_LEFT;
    }

    private boolean isScrollDirectionUndetermined(){
        return currentScrollDirection == SCROLLING_UNDETERMINED;
    }
}