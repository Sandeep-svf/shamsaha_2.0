package com.sam.shamsaha.volunteer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil

import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.ActivityChangePasswordBinding


class ChangePasswordActivity : AppCompatActivity() {

    lateinit var binding: ActivityChangePasswordBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password)


        binding.backArrow.setOnClickListener(View.OnClickListener {
            finish()
        })



    }
}