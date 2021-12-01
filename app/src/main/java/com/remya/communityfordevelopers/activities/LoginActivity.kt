package com.remya.communityfordevelopers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.remya.communityfordevelopers.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        initView()
    }

    private fun initView() {
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}