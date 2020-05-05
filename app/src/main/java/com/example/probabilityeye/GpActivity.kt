package com.example.probabilityeye

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ln

class GpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gp)
        val inputNumber = findViewById<EditText>(R.id.input_number)
        inputNumber.setText("0.1")

        val output = findViewById<TextView>(R.id.output_text)
        computeFunction(inputNumber.getText().toString().toDouble())

        inputNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val output = findViewById<TextView>(R.id.output_text)
                if (inputNumber.getText().toString() == "") {
                    output.text = "Introduceti un numar "
                    output_text.setTextColor(Color.rgb(255, 0, 0))

                } else {
                    val number = inputNumber.getText().toString().toDouble()
                    if (number < 1) {
                        if (number > 0)
                            computeFunction(inputNumber.getText().toString().toDouble())
                        else
                            output.text = "Introduceti un numar mai mare ca 0 "
                        output_text.setTextColor(Color.rgb(255, 0, 0))

                    } else {
                        output.text = "Introduceti un numar mai mic ca 1 "
                        output_text.setTextColor(Color.rgb(255, 0, 0))
                    }
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        // intents to the other activities

        val main_button = findViewById<Button>(R.id.bp)
        main_button.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }

        val dun_button = findViewById<Button>(R.id.dun)
        dun_button.setOnClickListener() {
            val intent = Intent(this, DunActivity::class.java)
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

        val l_button = findViewById<Button>(R.id.l)
        l_button.setOnClickListener {
            val intent = Intent(this, LActivity::class.java)
            startActivity(intent)
        }
    }
    private fun computeFunction(number: Double) {
        val randomNumber = Math.random()

        val output = findViewById<TextView>(R.id.output_text)
        val log = ln(1- randomNumber)/ (ln(1-number)+1)
        val new = log.toInt() +1
        output.text = new.toString()

    }
}
