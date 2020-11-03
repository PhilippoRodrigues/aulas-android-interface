package br.edu.infnet.androidloginsenha

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UsuarioCadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_cadastro)

        val btnCadastroUsuarioSalvar = this.findViewById<Button>(R.id.btnCadastroUsuarioSalvar)
        val editTextCadastroUsuarioNome = this.findViewById<TextView>(R.id.editTextTextCadastroUsuarioNome)

        btnCadastroUsuarioSalvar.setOnClickListener {
            var usuarioNome = editTextCadastroUsuarioNome.text.toString()

            //Verificar se o usuário digitou algo no input de nome do cadastro
            if (!usuarioNome.isNullOrBlank()) {
                var intentResult = Intent()
                intentResult.putExtra("usuarioNome", usuarioNome)

                //Configuração do retorno da requisição
                //Saber se a requisição retornou com um resultado correto e com os dados inseridos
                setResult(Activity.RESULT_OK, intentResult)
            } else {
                //Se o input estiver em branco ou vazio, cancelar a Activity
                setResult(Activity.RESULT_CANCELED)
            }

            //Retira a activity da pilha e é exibida a activity logo abaixo
            finish()
        }
    }
}