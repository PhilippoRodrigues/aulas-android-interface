package br.edu.infnet.androidloginsenha

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.edu.infnet.androidloginsenha.model.Usuario

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAcessar = this.findViewById<Button>(R.id.btnAcessar)
        val btnCadastro = this.findViewById<Button>(R.id.btnCadastrarse)
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
            startActivityForResult(alterHomeActivity, 5)
        }

        btnCadastro.setOnClickListener {
            var alterUsuarioCadastroActivity = Intent(this, UsuarioCadastroActivity::class.java)

            startActivityForResult(alterUsuarioCadastroActivity, 1022)
        }
    }

    //Obter as informações inseridas na activity de cadastro
    //requestCode: quem e o que está retornando
    //resultCode: saber se a resposta da requisição foi executada com sucesso
    //data: Intent passado no setResult()
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1022) {
            //Se o resultado da requisição for OK, os campos serão preenchidos com seus respectivos valores
            if (resultCode == Activity.RESULT_OK) {

                val editTextUsuarioNome = this.findViewById<TextView>(R.id.editTextTextUsuarioNome)
                //Pegar o valor que foi passado na resposta da activity de cadastro
                //Como a informação é passível de ser nula, acrescentar um "?" à propriedade "data"
                var usuarioNome = data?.getStringExtra("usuarioNome")
                //O nome é retornado para o input de nome da MainActivity
                editTextUsuarioNome.setText(usuarioNome)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(
                    this,
                    "Realize o cadastro antes de efetuar o login",
                    Toast.LENGTH_LONG
                ).show()
            }
        } else if (requestCode == 5){
            Toast.makeText(
                this,
                "Até breve!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}