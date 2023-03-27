package com.sam.shamsaha.volunteer.volcalendar

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

import com.google.android.gms.common.util.CollectionUtils.listOf
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentVolCalendarBinding
import com.sam.shamsaha.eventsmedia.RunWizardAdapter
import com.sam.shamsaha.eventsmedia.RunWizardListModel
import com.sam.shamsaha.volunteer.resources.VolCountryListAdapter
import com.sam.shamsaha.volunteer.resources.VolCountryListModel
import java.text.SimpleDateFormat
import java.util.*


class VolCalendar : Fragment() {

    lateinit var binding: FragmentVolCalendarBinding
    private var myadapter: RunWizardAdapterShiftLog? = null
    private lateinit var volShitLogList : List<RunWizardListModelShiftLog>
    val calendarView : CalendarView? = null
    private var currentDate: String? = null
    private val scrollView: ScrollView? = null
    private lateinit var volshiftListListAdapter: VolshiftListListAdapter
    private lateinit var valShiftList : List<volShiftListModel>
    private var i = 0




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


        val date = Calendar.getInstance().time
        val df = SimpleDateFormat("yyyy-MM-dd")
        currentDate = df.format(date)



        // add data i shift log
        losd_data_in_shift_list()


        //Recycler view
        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        // pass it to rvLists layoutManager
        binding.rcvShiftList.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        volshiftListListAdapter = VolshiftListListAdapter(requireContext(),valShiftList)
        // attach adapter to the recycler view


        if (::volshiftListListAdapter.isInitialized) {
            binding.rcvShiftList.adapter = volshiftListListAdapter
        }





        Log.d(TAG, "onCreate: $currentDate")
        binding.apply {
            allShift.setOnClickListener(View.OnClickListener {
                progressBar.visibility = View.VISIBLE
                //i = progressBar.progress

                allShift.setBackgroundResource(R.drawable.custom_text_view_shift);
                dayShift.setBackgroundResource(R.color.white);
                nightShift.setBackgroundResource(R.color.white);
                //progressBar.visibility = View.INVISIBLE
            })

            dayShift.setOnClickListener(View.OnClickListener {
                dayShift.setBackgroundResource(R.drawable.custom_text_view_shift);
                allShift.setBackgroundResource(R.color.white);
                nightShift.setBackgroundResource(R.color.white);
            })

            nightShift.setOnClickListener(View.OnClickListener {
                nightShift.setBackgroundResource(R.drawable.custom_text_view_shift);
                allShift.setBackgroundResource(R.color.white);
                dayShift.setBackgroundResource(R.color.white);
            })


            switchCompat.setOnClickListener(View.OnClickListener {


                if (switchCompat.isChecked) {
                    listView.visibility = View.VISIBLE
                    calendarView.visibility = View.GONE
                    Log.e("test_sam_compact", "checked");

                } else if (!switchCompat.isChecked) {
                    listView.visibility = View.GONE
                    calendarView.visibility = View.VISIBLE
                    Log.e("test_sam_compact", "un checked ###");

                } else {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                }


            })
        }

        // add data in model manually
        volShitLogList = listOf(
            RunWizardListModelShiftLog("21 Dec 2022", "English","6 AM 6 PM","Sam"),
            RunWizardListModelShiftLog("11 March 2023", "Arbic","7 AM 7 PM","Ankur"),
            RunWizardListModelShiftLog("31 Jan 2019", "Hindi","12 PM 12 AM","Master"),
            RunWizardListModelShiftLog("07 May 2018", "English","5 AM 5 PM","Bhanu"),
            RunWizardListModelShiftLog("14 March 2001", "arbic","4 AM 4 PM","Aarav"),
            RunWizardListModelShiftLog("07 May 2018", "English","5 AM 5 PM","Bhanu"))



        myadapter = RunWizardAdapterShiftLog(requireContext(), volShitLogList)
        binding.viewpager.adapter = myadapter
        binding.bannerIndicator.setViewPager(binding.viewpager)
        addDotNumber = volShitLogList.size
        binding.viewpager.addOnPageChangeListener(viewlistener)




        return view
    }

    private fun losd_data_in_shift_list() {

        // add data in shift list model...

        valShiftList = listOf(
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            ),
            volShiftListModel(
                "English",
                "23 March 2023",
                "6AM 6PM",
                R.drawable.ic_launcher_background
            )
        )
    }

    private fun hitShiftOnDateApi(currentDate: String) {

    }

    private fun HitMyShiftApi(currentDate: String) {

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


