package com.example.probabilityeye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.ln

class LActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l)
        val randomNumber = Math.random().toFloat()

        val output = findViewById<TextView>(R.id.output_text)
        output.text = ln(randomNumber/ (1-randomNumber)).toString()

        val main_button = findViewById<Button>(R.id.bp)
        main_button.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }

        val gp_button = findViewById<Button>(R.id.gp)
        gp_button.setOnClickListener {
            val intent = Intent(this, GpActivity::class.java)
            startActivity(intent)
        }

        val rmn_button = findViewById<Button>(R.id.rmn)
        rmn_button.setOnClickListener {
            val intent = Intent(this, RmnActivity::class.java)
            startActivity(intent)
        }


        val eteta_button = findViewById<Button>(R.id.eteta)
        eteta_button.setOnClickListener {
            val intent = Intent(this, EtetaActivity::class.java)
            startActivity(intent)
        }

        val dun_button = findViewById<Button>(R.id.dun)
        dun_button.setOnClickListener() {
            val intent = Intent(this, DunActivity::class.java)
            startActivity(intent)
        }
    }
}
