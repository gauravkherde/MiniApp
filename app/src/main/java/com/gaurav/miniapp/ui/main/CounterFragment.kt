package com.gaurav.miniapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gaurav.miniapp.R

class CounterFragment : Fragment() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   binding = FragmentCounterBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // binding = FragmentCounterBinding.inflate(layoutInflater, container, false)
        val view=inflater.inflate(R.layout.fragment_counter, container, false)
        var increment :Button= view.findViewById(R.id.increment)
        var decrement :Button= view.findViewById(R.id.decrement)
        var count :TextView = view.findViewById(R.id.Count)

        increment.setOnClickListener {
            counter += 1
            count.text = counter.toString()
        }
        decrement.setOnClickListener {
            counter -= 1
            count.text = counter.toString()
        }
        return  view
    }

    companion object {}


}