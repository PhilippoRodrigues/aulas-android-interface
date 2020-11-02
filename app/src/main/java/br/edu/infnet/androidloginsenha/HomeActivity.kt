package br.edu.infnet.androidloginsenha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var textViewUsuarioNome = this.findViewById<TextView>(R.id.textViewUsuarioNome)

        var usuarioNome = intent.getStringExtra("usuarioNome")
        textViewUsuarioNome.text = usuarioNome

    }
}