package com.remya.communityfordevelopers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.os.Handler
import com.remya.communityfordevelopers.ApiController
import com.remya.communityfordevelopers.R
import com.remya.communityfordevelopers.Skills
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var list: ArrayList<Skills>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val call: Call<ArrayList<Skills>>? = ApiController.getInstance()
            ?.getApi()
            ?.getAllSkills()

        call?.enqueue(object : Callback<ArrayList<Skills>> {
            override fun onFailure(call: Call<ArrayList<Skills>>, t: Throwable) {
                val error = t
            }

            override fun onResponse(call: Call<ArrayList<Skills>>, response: Response<ArrayList<Skills>>) {
                list = response.body()
            }

        })

        Handler().postDelayed({
            val sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

            if (sharedPreferences.contains(IS_USER_LOGGED_IN)) { // login data available

                if(sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false)) { // user logged in

                    val intent = Intent(this, DashboardActivity::class.java)
                    this.startActivity(intent)
                    this.finish()

                } else { // user not logged in

                    if (sharedPreferences.contains(IS_USER_REGISTERED)) { // sign up data available
                        if (sharedPreferences.getBoolean(IS_USER_REGISTERED, false)) { // user registered

                            val intent = Intent(this, LoginActivity::class.java)
                            this.startActivity(intent)
                            this.finish()

                        } else { // user not registered
                            val intent = Intent(this, SignUpActivity::class.java)
                            this.startActivity(intent)
                            this.finish()
                        }

                    } else { // sign up data unavailable
                        val intent = Intent(this, SignUpActivity::class.java)
                        this.startActivity(intent)
                        this.finish()
                    }

                }
            } else { // login data unavailable
                val intent = Intent(this, SignUpActivity::class.java)
                this.startActivity(intent)
                this.finish()
            }
        }, 3000)
    }

    companion object {
        const val IS_USER_LOGGED_IN = "is_user_logged_in"
        const val IS_USER_REGISTERED = "is_user_registered"
    }
}