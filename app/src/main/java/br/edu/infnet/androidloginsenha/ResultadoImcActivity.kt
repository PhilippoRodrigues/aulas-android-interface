package br.edu.infnet.androidloginsenha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.edu.infnet.androidloginsenha.model.Usuario
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class ResultadoImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc)

        val textViewUsuarioImc = this.findViewById<TextView>(R.id.textViewUsuarioImc)

        val usuario = intent.getSerializableExtra("usuario") as Usuario

        val imc = usuario.peso / (usuario.altura.pow(2.0))

        var classificacao = ""

        if (imc < 18.5)
            classificacao = "Magreza"
        else if (imc in 18.5..24.9)
            classificacao = "Normal"
        else if (imc in 25.0..29.9)
            classificacao = "Sobrepeso"
        else if (imc in 30.0..39.9)
            classificacao = "Obesidade"
        else
            classificacao = "Obesidade grave"

        textViewUsuarioImc.text =
            "$usuario\nIMC: ${"%.2f".format(imc)}\nClassificação: \t$classificacao"
    }
}