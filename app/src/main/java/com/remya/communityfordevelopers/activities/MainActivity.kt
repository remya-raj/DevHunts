package com.remya.communityfordevelopers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.remya.communityfordevelopers.ApiController
import com.remya.communityfordevelopers.R
import com.remya.communityfordevelopers.models.Skills
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        initData()

        Handler().postDelayed({
            val user = auth.currentUser
            if (user == null) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                startActivity(Intent(this, DashboardActivity::class.java))
            }
        }, 3000)
    }

    private fun initData() {
        auth = FirebaseAuth.getInstance()
    }
}