package com.tcoding.loginscreensharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tcoding.loginscreensharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding : ActivityMainBinding
   lateinit var sharedPreferences: SharedPreferences
   val FILE_NAME = "com.tcoding.loginscreensharedpreferences"
    val USERNAME = "username"
    val PASSWORD = "password"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE)



        val usernameKontrol: String? = sharedPreferences.getString(USERNAME,null)

        val passwordKontrol : String? = sharedPreferences.getString(PASSWORD, null)
        val intent = Intent(applicationContext, HomeScreen::class.java)



        if(usernameKontrol != null && passwordKontrol != null){
            startActivity(intent)
        }

        binding.buttonGiris.setOnClickListener {
            val gelenUsername: String = binding.editTextEmail.text.toString()
            val gelenPassword: String = binding.editTextPassword.text.toString()
            sharedPreferences.edit().putString(USERNAME,gelenUsername).apply()
            sharedPreferences.edit().putString(PASSWORD, gelenPassword).apply()

            startActivity(intent)

        }


    }
}