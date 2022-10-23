package com.gaurav.miniapp.ui.main

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.gaurav.miniapp.R
import com.gaurav.miniapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //  binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        var counter = view.findViewById<CardView>(R.id.FirstCard)
        var mirror = view.findViewById<CardView>(R.id.SecondCard)
        var torch = view.findViewById<CardView>(R.id.ThirdCart)
        counter.setOnClickListener {
            val counterFragment = CounterFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, counterFragment, null).addToBackStack(null).commit()

        }
        mirror.setOnClickListener {
            /*val mirrorFragment = MirrorFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, mirrorFragment, null).addToBackStack(null).commit()*/
            val ctx: Context = requireContext() // or you can replace **'this'** with your **ActivityName.this**

            try {
                val i: Intent? =
                    ctx.packageManager.getLaunchIntentForPackage("MediaStore.ACTION_IMAGE_CAPTURE")
                ctx.startActivity(i)
            } catch (e: PackageManager.NameNotFoundException) {
                // TODO Auto-generated catch block
            }

        }
        torch.setOnClickListener {
            val torchFragment = TorchFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, torchFragment, null).addToBackStack(null).commit()

        }
        return view

    }

}