package com.example.instanote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val email: EditText = findViewById(R.id.teEmailAddress)
        val password: EditText = findViewById(R.id.tePassword)
        val rbListenConfid: RadioButton = findViewById(R.id.rdConfidentialAgree)
        val rbListenData: RadioButton = findViewById(R.id.rbDataCollectionAgree)
        val btnLogIn: Button = findViewById(R.id.btnLogIn)
        val errorMessage: TextView = findViewById(R.id.tvErrorMessage)
        val ctvSignUp: TextView = findViewById(R.id.ctvSignUp)



        fun logInChecker(): Boolean {
            val email = email.text.toString()
            val password = password.text.toString()
            val rbListenConfId = rbListenConfid.isChecked
            val rbListenDataId = rbListenData.isChecked
            var checkId = false






            if (email.isNotEmpty() && password.isNotEmpty() && rbListenDataId && rbListenConfId) {

                checkId = true
                return checkId
            } else{
                return checkId
            }
        }



        btnLogIn.setOnClickListener{
          if(logInChecker()){
              val intent = Intent(this, MainPage::class.java)
              startActivity(intent)
              finish()
          }else{
              errorMessage.text = "Email or Password field is empty. Please check the Conditions"
          }
        }


        ctvSignUp.setOnClickListener {

            val signupval = Intent(this, SignUpClass::class.java)
            startActivity(signupval)
            finish()
        }



    }
}