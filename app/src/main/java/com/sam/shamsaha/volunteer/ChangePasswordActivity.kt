package com.sam.shamsaha.volunteer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_change_password);







    }
}