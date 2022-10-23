package com.gaurav.miniapp.Fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gaurav.miniapp.R
import com.gaurav.miniapp.databinding.FragmentMainBinding
import com.gaurav.miniapp.databinding.FragmentMirrorBinding


class MirrorFragment : Fragment() {
    private lateinit var binding: FragmentMirrorBinding

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMirrorBinding.inflate(layoutInflater)
        binding.mirror.setOnClickListener {
            try {
                val intent = Intent()
                intent.action = MediaStore.ACTION_IMAGE_CAPTURE
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return binding.root
    }
}