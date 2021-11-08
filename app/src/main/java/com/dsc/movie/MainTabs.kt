package com.dsc.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.dsc.movie.Adapter.MainTabsAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainTabs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tabs)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val viewPager2 = findViewById<ViewPager2>(R.id.vPager)

        val adapter = MainTabsAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="POPULAR"
                }
                1->{
                    tab.text="UPCOMING"
                }
            }
        }.attach()

    }

}