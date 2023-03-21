package com.sam.shamsaha.volunteer.volcalendar

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentVolCalendarBinding
import com.sam.shamsaha.eventsmedia.RunWizardAdapter
import com.sam.shamsaha.eventsmedia.RunWizardListModel
import com.sam.shamsaha.volunteer.resources.VolCountryListModel
import java.util.ArrayList


class VolCalendar : Fragment() {

    lateinit var binding: FragmentVolCalendarBinding
    private var myadapter: RunWizardAdapter? = null

    private lateinit var volShitLogList : List<RunWizardListModelShiftLog>



    // on page scroll in view pager
    var SCROLLING_RIGHT = 0
    var SCROLLING_LEFT = 1
    var SCROLLING_UNDETERMINED = 2
    var currentScrollDirection = 2
    private var addDotNumber = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentVolCalendarBinding.inflate(inflater,container,false)
        val view : View = binding.root
        // add data in model manually

        // add data in model manually
        volShitLogList = listOf(
            RunWizardListModelShiftLog("21 Dec 2022", "English"),
            RunWizardListModelShiftLog("11 March 2023", "Arbic"),
            RunWizardListModelShiftLog("31 Jan 2019", "Hindi"),
            RunWizardListModelShiftLog("07 May 2018", "English"),
            RunWizardListModelShiftLog("14 March 2001", "arbic"))



        myadapter = RunWizardAdapter(activity, volShitLogList)
        binding.viewpager.adapter = myadapter
        binding.bannerIndicator.setViewPager(binding.viewpager)
        addDotNumber = volShitLogList.size
        binding.viewpager.addOnPageChangeListener(viewlistener)
        binding.bannerIndicator.setViewPager(binding.viewpager);



        return view
    }

    var viewlistener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {

        }

        override fun onPageScrollStateChanged(state: Int) {}
    }



    private fun setScrollingDirection(positionOffset: Float) {
        if (1 - positionOffset >= 0.5) {
            currentScrollDirection = SCROLLING_RIGHT
        } else if (1 - positionOffset <= 0.5) {
            currentScrollDirection = SCROLLING_LEFT
        }
    }

    private fun isScrollingRight(): Boolean {
        return currentScrollDirection == SCROLLING_RIGHT
    }

    private fun isScrollingLeft(): Boolean {
        return currentScrollDirection == SCROLLING_LEFT
    }

    private fun isScrollDirectionUndetermined(): Boolean {
        return currentScrollDirection == SCROLLING_UNDETERMINED
    }
}


