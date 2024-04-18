package com.example.taskaffinityapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskaffinityapp.R


class RegisterFlowNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_flow_name)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val NextBtn: Button = findViewById(R.id.nextButton)
        NextBtn.setOnClickListener {

            val editTextName: EditText = findViewById(R.id.editTextName)
            val name = editTextName.text.toString()
            if (name.isNotEmpty())
            {
                val intent  = Intent(this, RegisterFlowSurnameActivity::class.java)
                intent.putExtra("name", name)

                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Имя не может быть пустым", Toast.LENGTH_SHORT).show()
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