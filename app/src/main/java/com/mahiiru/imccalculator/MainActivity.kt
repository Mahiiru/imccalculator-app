package com.mahiiru.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var currentWeight: Int = 60
    private var currentAge: Int = 21
    private var currentHeight: Int = 120
    private var isMaleSelected = true
    private var isFemaleSelected = false

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
        tvAge = findViewById(R.id.tvAge)
        btnMinusAge = findViewById(R.id.btnMinusAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnCalculate = findViewById(R.id.btnCalculate)
        cvMale = findViewById(R.id.cvMale)
        cvFemale = findViewById(R.id.cvFemale)
    }

    private fun initListeners() {
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            setHeight()
        }
        btnMinusWeight.setOnClickListener { minusActualWeight() }
        btnAddWeight.setOnClickListener { addActualWeight() }
        btnMinusAge.setOnClickListener { minusActualAge() }
        btnAddAge.setOnClickListener { addActualAge() }
        btnCalculate.setOnClickListener { changeToResultActivity() }
        cvMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cvFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        cvMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cvFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(genderSelected: Boolean): Int {
        val colorReference = if(genderSelected) {
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI() {
        setWeight()
        setAge()
        setHeight()
    }

    private fun changeToResultActivity() {
        val resultIMC : Double = calculateIMC()
        navigateToResult(resultIMC)
    }

    private fun navigateToResult(resultIMC: Double) {
        val intent = Intent(this,ImcResultActivity::class.java)
        intent.putExtra("IMC_RESULT",resultIMC)
        startActivity(intent)
    }

    private fun calculateIMC() : Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() /100 * currentHeight.toDouble() /100)
        return df.format(imc).toDouble()
    }

    private fun addActualAge() {
        if(currentAge < 130){
            currentAge += 1
            setAge()
        }
    }

    private fun minusActualAge() {
        if(currentAge > 0){
            currentAge -= 1
            setAge()
        }
    }

    private fun addActualWeight() {
        if(currentWeight < 300){
            currentWeight += 1
            setWeight()
        }
    }

    private fun minusActualWeight() {
        if(currentWeight > 0){
            currentWeight -= 1
            setWeight()
        }
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setHeight() {
        tvHeight.text = "$currentHeight cm"
    }

}