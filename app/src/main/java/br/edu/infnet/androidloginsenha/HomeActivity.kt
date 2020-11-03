package br.edu.infnet.androidloginsenha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.edu.infnet.androidloginsenha.model.Usuario

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var textViewUsuarioNome = this.findViewById<TextView>(R.id.textViewUsuarioNome)
        var btnCalcularImc = this.findViewById<Button>(R.id.btnCalcularIMC)
        var usuarioPeso = this.findViewById<TextView>(R.id.editTextUsuarioPeso)
        var usuarioAltura = this.findViewById<TextView>(R.id.editTextUsuarioAltura)
        //var usuarioNome = intent.getStringExtra("usuarioNome")

        //Obtém os dados do objeto que foram encapsulados na Activity de origem (MainActivity)
        var usuario = intent.getSerializableExtra("usuario") as Usuario

        //Exibir o valor da variável nome que está encapsulado no objeto
        textViewUsuarioNome.text = usuario.nome

        //Obter os valores de peso e altura quando clicar no botão "Calcular IMC"
        btnCalcularImc.setOnClickListener {
            var peso = usuarioPeso.text.toString()
            var altura = usuarioAltura.text.toString()

            //Converter os valores que estão em String para Float
            usuario.peso = peso.toDouble()
            usuario.altura = altura.toDouble()

            var alterResultadoImc = Intent(this, ResultadoImcActivity::class.java)
            alterResultadoImc.putExtra("usuario", usuario)
            startActivity(alterResultadoImc)
        }
    }
}