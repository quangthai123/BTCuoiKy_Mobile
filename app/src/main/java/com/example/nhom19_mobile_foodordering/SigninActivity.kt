package com.example.nhom19_mobile_foodordering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.nhom19_mobile_foodordering.databinding.ActivitySigninBinding
import com.example.nhom19_mobile_foodordering.model.UserModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SigninActivity : AppCompatActivity() {
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var username:String
    private lateinit var auth:FirebaseAuth
    private lateinit var database:DatabaseReference
    private lateinit var googleSigninClient:GoogleSignInClient

    private val binding: ActivitySigninBinding by lazy {
        ActivitySigninBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.defa))
        // initialize firebase auth
        auth = Firebase.auth

        // initialize firebase database
        database = Firebase.database.reference

//        googleSigninClient = GoogleSignIn.getClient(this, )

        binding.createAccountButton1.setOnClickListener {
            username = binding.userName.text.toString()
            email = binding.emailAddress.text.toString().trim()
            password = binding.password.text.toString().trim()

            if(email.isEmpty() || password.isBlank() || username.isBlank()) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            } else {
                createAccount(username, password)
            }
        }

        binding.alreadyhaveanaccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(username: String, password: String) {
       auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
           task ->
           if(task.isSuccessful) {
               Toast.makeText(this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show()
               saveUserData()
               startActivity(Intent(this, MainActivity::class.java))
               finish()
           } else {
               Toast.makeText(this, "Tạo tài khoản thất bại!", Toast.LENGTH_SHORT).show()
               Log.d("Account", "createAccount: Failure", task.exception)
           }
       }
    }

    private fun saveUserData() {
        // retrieve data from input field
        username = binding.userName.text.toString()
        email = binding.emailAddress.text.toString().trim()
        password = binding.password.text.toString().trim()

        val user = UserModel(username, email, password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        // save data to Firebase database
        database.child("user").child(userId).setValue(user)
    }
}