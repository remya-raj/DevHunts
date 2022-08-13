package com.remya.communityfordevelopers.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.remya.communityfordevelopers.databinding.ActivityRegisterUserBinding
import java.util.*
import kotlin.collections.HashMap


class RegisterUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterUserBinding
    lateinit var db: FirebaseFirestore
    lateinit var auth: FirebaseAuth
    lateinit var uri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
    }

    private fun initView() {

        binding.ivProfilePic.setOnClickListener {
            ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

        binding.btnGetStarted.setOnClickListener {
            uploadtofirebase()
        }
    }

    private fun initData() {
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
    }

    private fun uploadtofirebase() {
        val storage = FirebaseStorage.getInstance()
        val uploader = storage.getReference("Image1" + Random().nextInt(50))
        uploader.putFile(uri)
            .addOnSuccessListener(OnSuccessListener<Any?> {
                uploader.downloadUrl.addOnSuccessListener(OnSuccessListener<Uri> { uri ->
                    val user: MutableMap<String, Any> = HashMap()
                    user["Name"] = binding.etName.text.toString()
                    user["Age"] = binding.etAge.text.toString()
                    user["Skill"] = binding.etSkill.text.toString()
                    user["Image"] = uri.toString()

                    auth.currentUser?.let { it1 ->
                        db.collection("user").document(it1.uid).set(user)
                //                        .add(user)
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
                    Toast.makeText(applicationContext, "Uploaded", Toast.LENGTH_LONG).show()
                })
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            uri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            binding.ivProfilePic.setImageURI(uri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}