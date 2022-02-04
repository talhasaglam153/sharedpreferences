package com.tcoding.loginscreensharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tcoding.loginscreensharedpreferences.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    lateinit  var sharedPreferences: SharedPreferences
    lateinit var binding : ActivityHomeScreenBinding
    val FILE_NAME = "com.tcoding.loginscreensharedpreferences"
    val USERNAME = "username"
    val PASSWORD = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE)

        val gelenUsername: String? = sharedPreferences.getString(USERNAME, null)
        val gelenPassword: String? = sharedPreferences.getString(PASSWORD, null)


        binding.textViewUsername.text = gelenUsername
        binding.textViewPassword.text = gelenPassword

        binding.buttonCikis.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }





    }
}