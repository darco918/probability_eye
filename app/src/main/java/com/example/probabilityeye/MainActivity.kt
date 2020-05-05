package com.example.probabilityeye

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.TextWatcher
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber = findViewById<EditText>(R.id.input_number)
        inputNumber.setText("0.1")

        val output = findViewById<TextView>(R.id.output_text)
        computeFunction(inputNumber.getText().toString().toDouble())

        inputNumber.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                val output = findViewById<TextView>(R.id.output_text)
                if(inputNumber.getText().toString() == ""){
                    output.text = "Introduceti un numar "
                    output_text.setTextColor(Color.rgb(255, 0, 0))

                }
                else{
                    val number = inputNumber.getText().toString().toDouble()
                    if(number <1) {
                        if (number > 0)
                            computeFunction(inputNumber.getText().toString().toDouble())
                        else
                            output.text = "Introduceti un numar mai mare ca 0 "
                            output_text.setTextColor(Color.rgb(255, 0, 0))

                    }
                    else{
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

    }

    private fun computeFunction(number: Double) {
        val randomNumber = Math.random().toFloat()

        val output = findViewById<TextView>(R.id.output_text)

        if(number < randomNumber)
            output.text = "0"
        else{
            output.text = "1"
        }
    }
}
