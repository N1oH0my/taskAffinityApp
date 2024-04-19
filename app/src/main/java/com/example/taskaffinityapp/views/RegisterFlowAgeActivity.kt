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
import com.example.taskaffinityapp.MainActivity
import com.example.taskaffinityapp.R
import com.example.taskaffinityapp.models.User

import com.example.taskaffinityapp.models.BundleKeys.USER

class RegisterFlowAgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_flow_age)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val NextBtn: Button = findViewById(R.id.nextButton)
        NextBtn.setOnClickListener {
            val bundle = intent.extras
            val name = bundle?.getString("name")
            val surname = bundle?.getString("surname")

            val editTextAge: EditText = findViewById(R.id.editTextAge)
            val ageText = editTextAge.text.toString()

            try {
                val age = ageText.toInt()


                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK

                val user = User(name, surname, age)
                /*
                val nextBundle = Bundle()
                nextBundle.putSerializable("user", user)
                */
                val nextBundle = bundleOf(
                    USER to user
                )
                intent.putExtras(nextBundle)

                finishAffinity()
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Возраст должен быть целым числом и не пустым", Toast.LENGTH_SHORT).show()
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