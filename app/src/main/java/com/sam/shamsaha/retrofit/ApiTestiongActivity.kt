package com.sam.shamsaha.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.ActivityApiTestiongBinding
import com.sam.shamsaha.databinding.ActivityVolResourcesKotlinBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ApiTestiongActivity : AppCompatActivity() {

    // view binding for the activity
    private lateinit var binding: ActivityApiTestiongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiTestiongBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val quotesApi = ApiClient.getInstance().create(Apis::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes("name")
            if(result != null) {
                // Checking the results
                Log.d("ayush: ", result.body().toString())
            }
        }


    }
}