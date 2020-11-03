package br.edu.infnet.androidloginsenha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.edu.infnet.androidloginsenha.model.Usuario

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAcessar = this.findViewById<Button>(R.id.btnAcessar)
        var editTextUsuarioNome = this.findViewById<TextView>(R.id.editTextTextUsuarioNome)

        btnAcessar.setOnClickListener {
            var nomeUsuario = editTextUsuarioNome.text.toString()

            var usuario = Usuario(
                nomeUsuario,
                20,
                "21987654210",
                10910
            )

            var alterHomeActivity = Intent(this, HomeActivity::class.java)

            alterHomeActivity.putExtra("usuario", usuario)
            startActivity(alterHomeActivity)
        }
    }
}