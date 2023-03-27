package com.sam.shamsaha.volunteer.volcalendar

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sam.shamsaha.R


import com.sam.shamsaha.databinding.VolShiftListViewHolderBinding
import de.hdodenhof.circleimageview.CircleImageView

class VolshiftListListAdapter(val context: Context, val valShiftList : List<volShiftListModel>) :
    RecyclerView.Adapter<VolshiftListListAdapter.ShiftListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftListViewHolder {
        val binding = VolShiftListViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShiftListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShiftListViewHolder, position: Int) {

        with(holder){
            with(valShiftList[position]){
                binding.dateShiftListText.text = this.data
                binding.timeShiftList.text = this.time
                binding.languageShiftList.text = this.language
                Glide.with(context).load(valShiftList.get(position).profileImage).into(binding.valShiftListProfileImage)


                binding.itemView.setOnClickListener(View.OnClickListener {
                    // popup
                    val position : Int = position

                    popup_window()
                })
            }
        }

    }

    private fun popup_window() {
        val dialog = Dialog(context)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_shift_registration)
        val shift = dialog.findViewById(R.id.shift) as AppCompatTextView
        //shift.text = "sam"
        val accept_button = dialog.findViewById(R.id.accept_button) as AppCompatButton
        val cancel_image_view = dialog.findViewById(R.id.cancel_image_view) as CircleImageView
        accept_button.setOnClickListener {
            dialog.dismiss()
        }
        cancel_image_view.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun getItemCount(): Int {
      return valShiftList.size;
    }

    inner class ShiftListViewHolder(val binding: VolShiftListViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
}

