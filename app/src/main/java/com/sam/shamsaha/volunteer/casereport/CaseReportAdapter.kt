package com.sam.shamsaha.volunteer.casereport

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.CaseListViewHolderBinding
import com.sam.shamsaha.utility.UtilFun
import com.sam.shamsaha.volunteer.casereport.forms.CaseReportForm

class CaseReportAdapter (var context : Context, var caseList : List<CaseReportModel>):
    RecyclerView.Adapter<CaseReportAdapter.CaseReportViewHolder>() {

    inner class CaseReportViewHolder(val bindinng : CaseListViewHolderBinding) : RecyclerView.ViewHolder(bindinng.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseReportViewHolder {
        val binding = CaseListViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CaseReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CaseReportViewHolder, position: Int) {


        with(holder) {
            with(caseList[position]) {
                bindinng.timetv.text = this.date
                bindinng.caseidTv.text = this.caseId
                Glide.with(context).load(this.image).placeholder(R.drawable.ic_launcher_background)
                    .into(bindinng.imagecase)


                holder.bindinng.caseReportItemView.setOnClickListener(View.OnClickListener {
                    // call fragment
                    val activity =it.context as FragmentActivity
                    val caseReportForm = CaseReportForm()
                    UtilFun.replaceFragmentVol(activity,caseReportForm)
                })



            }
        }
    }

    override fun getItemCount(): Int {
       return caseList.size
    }


}