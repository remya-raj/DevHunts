package com.remya.communityfordevelopers.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.remya.communityfordevelopers.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnSignUp.setOnClickListener {
            val sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean(MainActivity.IS_USER_REGISTERED, true)
            editor.putBoolean(MainActivity.IS_USER_LOGGED_IN, true)
            editor.apply()

            val intent = Intent(this, DashboardActivity::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }
}