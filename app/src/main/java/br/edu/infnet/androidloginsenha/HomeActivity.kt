package br.edu.infnet.androidloginsenha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.edu.infnet.androidloginsenha.model.Usuario

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var textViewUsuarioNome = this.findViewById<TextView>(R.id.textViewUsuarioNome)
        //var usuarioNome = intent.getStringExtra("usuarioNome")

        //Obtém os dados do objeto que foram encapsulados na Activity de origem (MainActivity)
        var usuario = intent.getSerializableExtra("usuario") as Usuario

        //Exibir o valor da variável nome que está encapsulado no objeto
        textViewUsuarioNome.text = usuario.nome
    }
}