package com.example.instanote

import FirebaseAuthClass
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class SignUpClass : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)



        auth = FirebaseAuth.getInstance()


        val tiName: TextInputEditText = findViewById(R.id.tiName)
        val tiSurname: TextInputEditText = findViewById(R.id.tiSurname)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etPhone: EditText = findViewById(R.id.etPhone)
        val etBrthDay: EditText = findViewById(R.id.etBrthDay)
        //Button
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        //Error Messages
        val vtErrorName: TextView = findViewById(R.id.vtErrorName)
        val vtErrorSurname: TextView = findViewById(R.id.vtErrorSurname)
        val vtErrorEmail: TextView = findViewById(R.id.vtErrorEmail)
        val vtErrorPassword: TextView = findViewById(R.id.vtErrorPassword)
        val vtErrorPhone: TextView = findViewById(R.id.vtErrorPhone)
        val vtErrorBrthDay: TextView = findViewById(R.id.vtErrorBrthDay)


        fun emptyChecker(): Boolean {
            var passcond = false
            var errorCounter = 0
            if (tiName.text.toString().isEmpty()) {
                vtErrorName.text = "Name field cannot be empty"
                errorCounter++
            }
            if (tiSurname.text.toString().isEmpty()) {
                vtErrorSurname.text = "Surname field cannot be empty"
                errorCounter++
            }
            if (etEmail.text.toString().isEmpty()) {
                vtErrorEmail.text = "Email field cannot be empty"
                errorCounter++
            }
            if (etPassword.text.toString().isEmpty()) {
                vtErrorPassword.text = "Password field cannot be empty"
                errorCounter++
            }
            if (etPhone.text.toString().isEmpty()) {
                vtErrorPhone.text = "Phone field cannot be empty"
                errorCounter++
            }
            if (etBrthDay.text.toString().isEmpty()) {
                vtErrorBrthDay.text = "Birthdate field cannot be empty"
                errorCounter++
            }
            if (errorCounter == 0) {
                passcond = true
                return passcond
            } else {
                return passcond
            }
        }



        btnSubmit.setOnClickListener {
            if (emptyChecker()) {
                auth.createUserWithEmailAndPassword(
                    etEmail.text.toString(),
                    etPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    private fun emptyChecker(
        tiName: TextInputEditText,
        tiSurname: TextInputEditText,
        etEmail: EditText,
        etPassword: EditText,
        etPhone: EditText,
        etBrthDay: EditText,
        vtErrorName: TextView,
        vtErrorSurname: TextView,
        vtErrorEmail: TextView,
        vtErrorPassword: TextView,
        vtErrorPhone: TextView,
        vtErrorBrthDay: TextView
    ): Boolean {
        var passcond = true
        vtErrorName.text = ""
        vtErrorSurname.text = ""
        vtErrorEmail.text = ""
        vtErrorPassword.text = ""
        vtErrorPhone.text = ""
        vtErrorBrthDay.text = ""

        if (tiName.text.toString().isEmpty()) {
            vtErrorName.text = "Name field cannot be empty"
            passcond = false
        }
        if (tiSurname.text.toString().isEmpty()) {
            vtErrorSurname.text = "Surname field cannot be empty"
            passcond = false
        }
        if (etEmail.text.toString().isEmpty()) {
            vtErrorEmail.text = "Email field cannot be empty"
            passcond = false
        }
        if (etPassword.text.toString().isEmpty()) {
            vtErrorPassword.text = "Password field cannot be empty"
            passcond = false
        }
        if (etPhone.text.toString().isEmpty()) {
            vtErrorPhone.text = "Phone field cannot be empty"
            passcond = false
        }
        if (etBrthDay.text.toString().isEmpty()) {
            vtErrorBrthDay.text = "Birthdate field cannot be empty"
            passcond = false
        }
        return passcond
    }
}
