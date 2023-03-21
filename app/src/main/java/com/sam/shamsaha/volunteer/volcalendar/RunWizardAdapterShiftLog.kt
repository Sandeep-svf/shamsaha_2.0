package com.sam.shamsaha.volunteer.volcalendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.sam.shamsaha.R

class RunWizardAdapterShiftLog (val context : Context, val list :  List<RunWizardListModelShiftLog>) :
    PagerAdapter() {
    var inflater : LayoutInflater? = null

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater!!.inflate(R.layout.run_wizard_view_holder_shift_log, container, false)

        val date = view.findViewById<View>(R.id.date) as TextView
        val time = view.findViewById<View>(R.id.time) as TextView
        val volName = view.findViewById<View>(R.id.vol_name) as TextView
        val languageVol = view.findViewById<View>(R.id.language_vol) as TextView

        date.text = list.get(position).date
        time.text = list.get(position).time
        volName.text = list.get(position).volName
        languageVol.text = list.get(position).language


        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}