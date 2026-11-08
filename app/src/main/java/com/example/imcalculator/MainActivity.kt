package com.example.imcalculator

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val loadingHandler = Handler(Looper.getMainLooper())
    private val openCalculo = Runnable {
        startActivity(Intent(this, CalculoActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        // Pausa visual da abertura; ainda nao ha uma tarefa de carregamento real.
        loadingHandler.postDelayed(openCalculo, 2_000L)
    }

    override fun onStop() {
        loadingHandler.removeCallbacks(openCalculo)
        super.onStop()
    }
}
