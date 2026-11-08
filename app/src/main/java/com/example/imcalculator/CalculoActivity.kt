package com.example.imcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val pesoStr = edtPeso.text.toString().replace(",", ".")
            val peso = pesoStr.toDoubleOrNull()

            if(peso == null || peso <= 0){
                edtPeso.error = "Digite um peso válido maior que zero"
                return@setOnClickListener
            }

            val alturaStr = edtAltura.text.toString().replace(",", ".")
            val altura = alturaStr.toDoubleOrNull()

            if(altura == null || altura <= 0){
                edtAltura.error = "Digite uma altura válida maior que zero"
                return@setOnClickListener
            }

            val imc = peso / (altura * altura)
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
    }
}