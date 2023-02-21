package com.mahiiru.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var currentWeight: Int = 60
    private var currentAge: Int = 21
    private var currentHeight: Int = 120

    private lateinit var cvMale : CardView
    private lateinit var cvFemale : CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnMinusWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnMinusAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnCalculate : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnMinusWeight = findViewById(R.id.btnMinusWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
    }

    private fun initListeners() {
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"

        }
        btnMinusWeight.setOnClickListener { minusActualWeight() }
        btnAddWeight.setOnClickListener { addActualWeight() }

    }

    private fun addActualWeight() {
        if(currentWeight < 300){
            currentWeight += 1
            tvWeight.text = currentWeight.toString()
        }
    }

    private fun minusActualWeight() {
        if(currentWeight > 0){
            currentWeight -= 1
            tvWeight.text = currentWeight.toString()
        }
    }

    private fun initUI() {
        setWeigth()
        setAge()
    }

    private fun setWeigth() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

}