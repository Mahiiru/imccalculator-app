package com.mahiiru.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class ImcResultActivity : AppCompatActivity() {

    private lateinit var tvResultTitle:TextView
    private lateinit var tvResultValue:TextView
    private lateinit var tvResultDescription:TextView
    private lateinit var btnRecalculate:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        val imc: Double = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
        initComponents()
        initUI(imc)
        initListeners()
    }

    private fun initComponents() {
        tvResultTitle = findViewById(R.id.tvResultTitle)
        tvResultValue = findViewById(R.id.tvResultValue)
        tvResultDescription = findViewById(R.id.tvResultDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initUI(imc: Double) {
        tvResultValue.text = imc.toString()
        when(imc){
            in 0.00..18.50 -> {
                tvResultTitle.text = getString(R.string.title_bajo_peso)
                tvResultTitle.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvResultDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> {
                tvResultTitle.text = getString(R.string.title_peso_normal)
                tvResultTitle.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvResultDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> {
                tvResultTitle.text = getString(R.string.title_sobrepeso)
                tvResultTitle.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                tvResultDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.99 -> {
                tvResultTitle.text = getString(R.string.title_obesidad)
                tvResultTitle.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                tvResultDescription.text = getString(R.string.description_obesidad)
            }
            else ->{
                tvResultTitle.text = getString(R.string.error)
                tvResultTitle.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                tvResultDescription.text = getString(R.string.error)
                tvResultValue.text = getString(R.string.error)
            }
        }

    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }
}