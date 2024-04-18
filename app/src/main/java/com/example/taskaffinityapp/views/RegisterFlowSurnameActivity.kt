package com.example.taskaffinityapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskaffinityapp.R

class RegisterFlowSurnameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_flow_surname)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val NextBtn: Button = findViewById(R.id.nextButton)
        NextBtn.setOnClickListener {
            val name = intent.getStringExtra("name")

            val editTextName: EditText = findViewById(R.id.editTextSurname)
            val surname = editTextName.text.toString()
            if (surname.isNotEmpty()){
                val bundle = bundleOf(
                    "name" to name,
                    "surname" to surname
                )

                val intent  = Intent(this, RegisterFlowAgeActivity::class.java)
                intent.putExtras(bundle)

                startActivity(intent)
            }else{
                Toast.makeText(this, "Фамилия не может быть пустой", Toast.LENGTH_SHORT).show()
            }
        }
        val BackBtn: Button = findViewById(R.id.backButton)
        BackBtn.setOnClickListener {
            finish()
        }

        val closeRegistrationFlowBtn: Button = findViewById(R.id.closeButton)
        closeRegistrationFlowBtn.setOnClickListener {

            finishAffinity()
        }
    }
}