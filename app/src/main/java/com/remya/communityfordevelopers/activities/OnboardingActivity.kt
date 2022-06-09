package com.remya.communityfordevelopers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewpager.widget.ViewPager
import com.cuberto.liquid_swipe.LiquidPager
import com.remya.communityfordevelopers.R
import com.remya.communityfordevelopers.adapters.ViewPagerAdapter
import com.remya.communityfordevelopers.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportActionBar?.hide()
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,1)
        binding.pager.adapter = viewPagerAdapter
    }
}