package com.sam.shamsaha.volunteer.pastreport

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.CaseListViewHolderBinding
import com.sam.shamsaha.utility.UtilFun


class PastReportAdapter (var context : Context, var caseList : List<PastReportModel>):
    RecyclerView.Adapter<PastReportAdapter.PastReportViewHolder>() {

    inner class PastReportViewHolder(val bindinng : CaseListViewHolderBinding) : RecyclerView.ViewHolder(bindinng.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastReportViewHolder {
        val binding = CaseListViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PastReportViewHolder(binding)
    }



    override fun getItemCount(): Int {
        return caseList.size
    }

    override fun onBindViewHolder(holder: PastReportViewHolder, position: Int) {
         with(holder) {
            with(caseList[position]) {
                bindinng.timetv.text = this.date
                bindinng.caseidTv.text = this.caseId
                Glide.with(context).load(this.image).placeholder(R.drawable.ic_launcher_background)
                    .into(bindinng.imagecase)


                holder.bindinng.caseReportItemView.setOnClickListener(View.OnClickListener {
                    // call fragment
                    val activity =it.context as FragmentActivity
                    val pastreportDetails = PastreportDetails()
                    UtilFun.replaceFragmentVol(activity,pastreportDetails)
                })



            }
        }
    }
}