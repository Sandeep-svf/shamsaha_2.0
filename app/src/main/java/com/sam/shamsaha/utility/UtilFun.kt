package com.sam.shamsaha.utility

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.sam.shamsaha.R

class UtilFun {

    companion object replaceFragment{

        fun replaceFragmentVol(activity: FragmentActivity, fragment : Fragment){
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.container_vol,fragment)
                .addToBackStack(null)
                .commit()
        }


        fun replaceFragmentVictim(activity: FragmentActivity, fragment: Fragment){
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit()
        }


    }

}