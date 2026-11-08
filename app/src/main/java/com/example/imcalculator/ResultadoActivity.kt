package com.example.imcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imc = intent.getDoubleExtra("IMC", 0.0)
        val tvIMC = findViewById<TextView>(R.id.tvIMC)
        tvIMC.text = String.format("%.2f", imc)

        val tvCondition = findViewById<TextView>(R.id.tvCondition)

        if (imc < 18.5) {
            tvCondition.text = "Abaixo do peso"
            tvCondition.setTextColor(getColor(R.color.button))
        } else if (imc < 24.9) {
            tvCondition.text = "Peso normal"
            tvCondition.setTextColor(getColor(R.color.button))
        } else if (imc < 29.9) {
            tvCondition.text = "Sobrepeso"
            tvCondition.setTextColor(getColor(R.color.orange))
        } else if (imc < 34.9) {
            tvCondition.text = "Obesidade Grau I"
            tvCondition.setTextColor(getColor(R.color.red))
        } else if (imc < 39.9) {
            tvCondition.text = "Obesidade Grau II"
            tvCondition.setTextColor(getColor(R.color.red))
        } else {
            tvCondition.text = "Obesidade Grau III"
            tvCondition.setTextColor(getColor(R.color.red))
            }

        val btnRecalcular = findViewById<Button>(R.id.btnRecalcular)
        btnRecalcular.setOnClickListener {
            finish()
        }

    }
}