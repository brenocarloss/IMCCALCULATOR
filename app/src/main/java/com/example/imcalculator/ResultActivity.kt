package com.example.imcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()
        /*Menor que 18,5	Magreza
        18,5 a 24,9	Normal
        25 a 29,9	Sobrepeso
        30 a 34,9	Obesidade grau I
        35 a 39,9	Obesidade grau II
        Maior que 40	Obesidade grau III*/

        var classificacao = ""

        if (result < 18.5){
            classificacao ="Abaixo do peso ideal"
        }else if(result in 18.5..24.9){
            classificacao ="Peso ideal"
        }else if(result in 25.0..29.9){
            classificacao ="Sobrepeso"
        }else if(result in 30.0..34.9){
            classificacao ="Obesidade grau I"
        }else if(result in 35.0..39.9){
            classificacao ="Obesidade grau II"
        }else if (result > 40){
            classificacao = "Obesidade grau III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}