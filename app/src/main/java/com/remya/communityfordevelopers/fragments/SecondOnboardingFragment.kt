package com.remya.communityfordevelopers.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.remya.communityfordevelopers.R
import com.remya.communityfordevelopers.activities.LoginActivity
import com.remya.communityfordevelopers.databinding.FragmentSecondOnboardingBinding

class SecondOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentSecondOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        binding.btnSkip.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondOnboardingBinding.inflate(inflater,container,false)
        return binding.root
    }
}