package com.example.probabilityeye

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typeface = Typeface.createFromAsset(assets, "Kastelov_Axiforma_Regular.otf")
        instructions.typeface = typeface

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

        val dun_button = findViewById<Button>(R.id.dun)
        dun_button.setOnClickListener() {
            val intent = Intent(this, DunActivity::class.java)
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

        val l_button = findViewById<Button>(R.id.l)
        l_button.setOnClickListener {
            val intent = Intent(this, LActivity::class.java)
            startActivity(intent)
        }

    }

    private fun computeFunction(number: Double) {
        val randomNumber = Math.random().toFloat()

        val output = findViewById<TextView>(R.id.output_text)

        if (number < randomNumber)
            output.text = "0"
        else {
            output.text = "1"
        }
    }
}
