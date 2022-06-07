package com.remya.communityfordevelopers.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.remya.communityfordevelopers.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initData()
        initView()
    }

    private fun initView() {
        binding.btnSignUp.setOnClickListener {

            auth.createUserWithEmailAndPassword(binding.etEmail.text.toString(), binding.etPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        if (user != null) {
                            db.collection("user").document(user.uid)
                        }
                        startActivity(Intent(this, RegisterUserActivity::class.java))
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed." + task.exception.toString(),
                            Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun initData() {
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
    }
}