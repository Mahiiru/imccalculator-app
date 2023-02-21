package com.mahiiru.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

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
        TODO("Not yet implemented")
    }

    private fun initListeners() {
        TODO("Not yet implemented")
    }

    private fun initUI() {
        TODO("Not yet implemented")
    }

}