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
import com.gaurav.miniapp.Fragment.CalculatorFragment
import com.gaurav.miniapp.Fragment.CounterFragment
import com.gaurav.miniapp.Fragment.MirrorFragment
import com.gaurav.miniapp.Fragment.TorchFragment
import com.gaurav.miniapp.R
import com.gaurav.miniapp.databinding.FragmentCalculatorBinding
import com.gaurav.miniapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
          binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        binding.FirstCard.setOnClickListener {
            val counterFragment = CounterFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, counterFragment, null).addToBackStack(null).commit()

        }
        binding.SecondCard.setOnClickListener {
            val mirrorFragment = MirrorFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, mirrorFragment, null).addToBackStack(null).commit()

        }
        binding.ThirdCart.setOnClickListener {
            val torchFragment = TorchFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, torchFragment, null).addToBackStack(null).commit()

        }
        binding.SecondRowFirstCard.setOnClickListener {
            val calculator = CalculatorFragment()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.mainFragment, calculator, null).addToBackStack(null).commit()

        }
        return binding.root

    }

}