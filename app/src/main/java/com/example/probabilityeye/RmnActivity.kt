package com.example.probabilityeye

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ln

class RmnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rmn)
        val typeface = Typeface.createFromAsset(assets, "Kastelov_Axiforma_Regular.otf")
        instructions.typeface = typeface

        val inputNumber = findViewById<EditText>(R.id.input_number)
        inputNumber.setText("1")

        val inputNumberN = findViewById<EditText>(R.id.input_number_n)
        inputNumberN.setText("2")

        val output = findViewById<TextView>(R.id.output_text)
        computeFunction(inputNumber.getText().toString().toDouble(), inputNumberN.getText().toString().toDouble())


        //this is for M
        inputNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val output = findViewById<TextView>(R.id.output_text)
                if (inputNumber.getText().toString() == "") {
                    output.text = "Introduceti un numar "
                    output_text.setTextColor(Color.rgb(255, 0, 0))

                } else {
                    if(inputNumber.getText().toString().toDouble() <  inputNumberN.getText().toString().toDouble())
                        computeFunction(inputNumber.getText().toString().toDouble(), inputNumberN.getText().toString().toDouble())
                    else{
                        val  placeHolder= "Introduceti M mai mic ca "+  inputNumberN.getText().toString()
                        output.text = placeHolder
                        output_text.setTextColor(Color.rgb(255, 0, 0))

                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        //this for n
        inputNumberN.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val output = findViewById<TextView>(R.id.output_text)
                if (inputNumberN.getText().toString() == "") {
                    output.text = "Introduceti un numar "
                    output_text.setTextColor(Color.rgb(255, 0, 0))
                } else {
                    if(inputNumber.getText().toString().toDouble() <  inputNumberN.getText().toString().toDouble())
                        computeFunction(inputNumber.getText().toString().toDouble(), inputNumberN.getText().toString().toDouble())
                    else{
                        val  placeHolder= "Introduceti M mai mic ca "+  inputNumberN.getText().toString()
                        output.text = placeHolder
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

        val gp_button = findViewById<Button>(R.id.gp)
        gp_button.setOnClickListener {
            val intent = Intent(this, GpActivity::class.java)
            startActivity(intent)
        }

        val lButton = findViewById<Button>(R.id.l)
        lButton.setOnClickListener {
            val intent = Intent(this, LActivity::class.java)
            startActivity(intent)
        }


        val eteta_button = findViewById<Button>(R.id.eteta)
        eteta_button.setOnClickListener {
            val intent = Intent(this, EtetaActivity::class.java)
            startActivity(intent)
        }

    }
    private fun computeFunction(numberM: Double, numberN: Double) {
        val randomNumber = Math.random()

        val output = findViewById<TextView>(R.id.output_text)
//        val new = log.toInt() +1
        output.text = (numberM+numberN).toString()
    }
}
