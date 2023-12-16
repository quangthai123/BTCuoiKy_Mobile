package com.example.nhom19_mobile_foodordering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nhom19_mobile_foodordering.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//    private lateinit var email:String
//    private lateinit var password:String
//    private lateinit var auth: FirebaseAuth
//    private lateinit var database: FirebaseDatabase
//    private lateinit var googleSignInClient: GoogleSignInClient
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.loginbutton.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }
        binding.donthavebutton.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }
    }
}