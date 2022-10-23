package com.gaurav.miniapp.Fragment

import android.content.Context.CAMERA_SERVICE
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.gaurav.miniapp.R

class TorchFragment : Fragment() {
    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId: String
    private lateinit var toggleButton: ToggleButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_torch, container, false)
        val isFlashAvailable = requireContext().packageManager
            .hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)

        cameraManager = requireContext().getSystemService(CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
        toggleButton = view.findViewById(R.id.onOffFlashlight)
        toggleButton.setOnCheckedChangeListener { _, isChecked -> switchFlashLight(isChecked) }

        return view
    }
    private fun switchFlashLight(status: Boolean) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, status)
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}