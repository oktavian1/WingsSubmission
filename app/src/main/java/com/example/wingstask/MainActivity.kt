package com.example.wingstask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wingstask.databinding.ActivityMainBinding
import com.example.wingstask.ui.ListProductActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                val userName = binding.edtUser.text.toString()
                val password = binding.edtPassword.text.toString()

                if (userName.isNotEmpty() && password.isNotEmpty()) {
                    signWithEmailPassword(userName, password)
                } else {
                    Toast.makeText(this, "Harap Diisi", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun signWithEmailPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Intent(this, ListProductActivity::class.java)
                        .also(this::startActivity)
                } else {
                    Toast.makeText(this, "Something problem please try again", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}