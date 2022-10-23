package com.gaurav.miniapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.gaurav.miniapp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.MainContainer, mainFragment).commit()

    }
    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount != 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}