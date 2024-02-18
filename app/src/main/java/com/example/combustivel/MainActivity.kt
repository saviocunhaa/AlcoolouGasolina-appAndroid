package com.example.combustivel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText
    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponetesInterface()

        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }


    }

    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if (resultadoValidacao){
            val alcoolNumero = precoAlcool.toDouble()
            val gasolinaNumero = precoGasolina.toDouble()

            val resultado = alcoolNumero / gasolinaNumero
            if (resultado >= 0.7){
                textResultado.text = "Melhor Utilizar Gasolina"
                textResultado.setTextColor(Color.RED)

            } else{
                textResultado.text = "Melhor Utilizar Alcool"
                textResultado.setTextColor(Color.RED)
            }
        }

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error  = null

        if (pAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        }else if (pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }
        return true
    }

    private fun inicializarComponetesInterface() {
        textInputAlcool = findViewById(R.id.textInputAlcool)
        editAlcool = findViewById(R.id.editAlcool)

        textInputGasolina = findViewById(R.id.textInputGasolina)
        editGasolina = findViewById(R.id.editGasolina)

        btnCalcular = findViewById(R.id.btnCalcular)
        textResultado = findViewById(R.id.txtResultado)
    }
}