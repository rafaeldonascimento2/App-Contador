package com.example.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val textViewCount = findViewById<TextView>(R.id.textViewCount)
        val buttonIncrement = findViewById<Button>(R.id.buttonIncrement)
        val buttonDecrement = findViewById<Button>(R.id.buttonDecrement)

        textViewCount.text = count.toString()

        buttonIncrement.setOnClickListener {
            count++
            textViewCount.text = count.toString()
        }

        buttonDecrement.setOnClickListener {
            if(count == 0 ){
                Toast.makeText(this,"Contador não funciona menos que 0",Toast.LENGTH_SHORT) .show()
                return@setOnClickListener
            }
            count--
            textViewCount.text = count.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
