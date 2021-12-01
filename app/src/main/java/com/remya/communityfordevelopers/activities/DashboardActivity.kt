package com.remya.communityfordevelopers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View

import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.DefaultItemAnimator

import android.view.animation.LinearInterpolator

import android.widget.TextView

import android.widget.Toast
import com.remya.communityfordevelopers.CardStackAdapter
import com.remya.communityfordevelopers.callbacks.CardStackCallback
import com.remya.communityfordevelopers.ItemModel
import com.remya.communityfordevelopers.R
import com.remya.communityfordevelopers.databinding.ActivityDashboardBinding
import com.remya.communityfordevelopers.fragments.ChatFragment
import com.remya.communityfordevelopers.fragments.HomeFragment
import com.remya.communityfordevelopers.fragments.MatchesFragment
import com.remya.communityfordevelopers.fragments.ProfileFragment
import com.yuyakaido.android.cardstackview.*


class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when(it.itemId) {
                R.id.menu_home -> transaction.replace(R.id.fragmentContainerView, HomeFragment())
                R.id.menu_matches -> transaction.replace(R.id.fragmentContainerView, MatchesFragment())
                R.id.menu_chat -> transaction.replace(R.id.fragmentContainerView, ChatFragment())
                R.id.menu_profile -> transaction.replace(R.id.fragmentContainerView, ProfileFragment())
            }
            transaction.commit()
            return@setOnItemSelectedListener true
        }
    }
}