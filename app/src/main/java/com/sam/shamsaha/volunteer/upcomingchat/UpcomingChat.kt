package com.sam.shamsaha.volunteer.upcomingchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.FragmentUpcomingChatBinding
import com.sam.shamsaha.volunteer.casereport.CaseReportAdapter
import com.sam.shamsaha.volunteer.casereport.CaseReportModel

class UpcomingChat : Fragment() {

    lateinit var binding : FragmentUpcomingChatBinding
    lateinit var upcomingChatAdapter : UpcomingChatAdapter
    lateinit var upcomingChatList: List<UpcomingChatModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentUpcomingChatBinding.inflate(inflater,container,false)
        val view : View = binding.root

       load_upcoming_chat_list_data()


        // using recyler view
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rv list layout manager
        binding!!.rcvUpcomiongChatList.setLayoutManager(layoutManager)

        // initialized the obj and pass the req obj
        upcomingChatAdapter  = UpcomingChatAdapter(requireContext(), upcomingChatList)

        // attach adapter to the reycler view
        binding.rcvUpcomiongChatList.adapter = upcomingChatAdapter



        return view
    }

    private fun load_upcoming_chat_list_data() {
        upcomingChatList = listOf(
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM"),
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM"),
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM"),
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM"),
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM"),
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM"),
            UpcomingChatModel(R.drawable.ic_launcher_background,"Sam","02 Oct 2023 05:48 PM")
        )
    }
}