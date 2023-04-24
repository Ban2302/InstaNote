package com.example.instanote

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.textfield.TextInputEditText

class SignUpClass : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Shared Preferences





        val tiName : TextInputEditText = findViewById(R.id.tiName)
        val tiSurname : TextInputEditText = findViewById(R.id.tiSurname)
        val etEmail : EditText = findViewById(R.id.etEmail)
        val etPassword : EditText = findViewById(R.id.etPassword)
        val etPhone : EditText = findViewById(R.id.etPhone)
        val etBrthDay : EditText = findViewById(R.id.etBrthDay)
        //Button
        val btnSubmit : Button = findViewById(R.id.btnSubmit)

        //Error Messages
        val vtErrorName : TextView = findViewById(R.id.vtErrorName)
        val vtErrorSurname : TextView = findViewById(R.id.vtErrorSurname)
        val vtErrorEmail : TextView = findViewById(R.id.vtErrorEmail)
        val vtErrorPassword : TextView = findViewById(R.id.vtErrorPassword)
        val vtErrorPhone : TextView = findViewById(R.id.vtErrorPhone)
        val vtErrorBrthDay : TextView = findViewById(R.id.vtErrorBrthDay)


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



btnSubmit.setOnClickListener{
    if(emptyChecker()){
        Toast.makeText(this,"Good", Toast.LENGTH_LONG).show()


    }
}



    }
}