package com.sam.shamsaha.pickimagecameragalary

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.sam.shamsaha.BuildConfig
import com.sam.shamsaha.R
import com.sam.shamsaha.databinding.ActivityPickImageBinding
import java.io.File

class PickImagelocalActivity : AppCompatActivity() {

    lateinit var binding : ActivityPickImageBinding
    val REQUEST_CODE = 200
    val REQUEST_CODE2 = 210

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_imagelocal)
        binding = ActivityPickImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openEventButton2.setOnClickListener(View.OnClickListener {
            capturePhoto()
        })

        binding.openEventButton.setOnClickListener(View.OnClickListener {
            openGalleryForImages()
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){

            // if multiple images are selected
            if (data?.getClipData() != null) {
                var count = data.clipData!!.itemCount

                for (i in 0..count - 1) {
                    var imageUri: Uri = data.clipData!!.getItemAt(i).uri

                   // path
                    val path: String = URIPathHelper.getPath(this,imageUri)!!
                    Log.d("test_sam_filepath"," 1:"+imageUri)
                    Log.d("test_sam_filepath"," path:"+path)

                    binding.image.setImageURI(imageUri) //Here you can assign your Image URI to the ImageViews
                }

            } else if (data?.getData() != null) {
                // if single image is selected

                var imageUri: Uri = data.data!!
                binding.image.setImageURI(imageUri) //Here you can assign the picked image uri to your imageview
                // path
                val path: String = URIPathHelper.getPath(this,imageUri)!!
                Log.d("test_sam_filepath"," 2:"+imageUri)
                Log.d("test_sam_filepath"," path:"+path)
            }


        }
        else if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){

        }
    }

    fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE2)
    }

    private fun openGalleryForImages() {

        if (Build.VERSION.SDK_INT < 19) {
            var intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Choose Pictures")
                , REQUEST_CODE
            )
        }
        else { // For latest versions API LEVEL 19+
            var intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE);
        }

    }


}

