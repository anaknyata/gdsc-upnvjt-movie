package com.dsc.movie

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.dsc.movie.Adapter.MainTabsAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        val runnable = Runnable {
            val intent = Intent(this@MainActivity, MainTabs::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable, 2000)
    }
}