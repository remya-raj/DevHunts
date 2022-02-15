package com.remya.communityfordevelopers.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.remya.communityfordevelopers.databinding.ActivityRegisterUserBinding


class RegisterUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterUserBinding
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
    }

    private fun initView() {
        binding.btnGetStarted.setOnClickListener {
            val user: MutableMap<String, Any> = HashMap()
            user["Name"] = binding.etName.text.toString()
            user["Age"] = binding.etAge.text.toString()
            user["Skill"] = binding.etSkill.text.toString()

            db.collection("user")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(
                        this,
                        "Successful",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    private fun initData() {
        db = FirebaseFirestore.getInstance()
    }
}