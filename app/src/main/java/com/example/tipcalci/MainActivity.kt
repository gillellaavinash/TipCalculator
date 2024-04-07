package com.example.tipcalci

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bill = findViewById<EditText>(R.id.bill)
        var tipPercent = findViewById<TextView>(R.id.tip_percent)
        seekBar = findViewById(R.id.progress)
        val tip = findViewById<TextView>(R.id.tip)
        val total = findViewById<TextView>(R.id.total)


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tipPercent.text = progress.toString()
                val inputBill = bill.text.toString()
                if(inputBill.isNotEmpty()) {
                    val tipAmount = inputBill.toInt()
                    var caluclatedTip = tipAmount * progress / 100
                    tip.text = String.format("$ %d", caluclatedTip)
                    val totalAmount = (tipAmount * progress / 100) + tipAmount
                    total.text = String.format("$ %d", totalAmount)
                }
                else{
                    tip.text=""
                    total.text=""
                    Toast.makeText(this@MainActivity,"Please enter a integer number",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }


        })
    }
}