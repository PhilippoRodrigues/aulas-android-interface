package br.edu.infnet.androidloginsenha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAcessar = this.findViewById<Button>(R.id.btnAcessar)
        var editTextUsuarioNome = this.findViewById<TextView>(R.id.editTextTextUsuarioNome)

        btnAcessar.setOnClickListener {
            var nomeUsuario = editTextUsuarioNome.text.toString()
            var alterHomeActivity = Intent(this, HomeActivity::class.java)

            alterHomeActivity.putExtra("usuarioNome", nomeUsuario)
            startActivity(alterHomeActivity)
        }
    }
}