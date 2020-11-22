package br.edu.infnet.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener{

    private lateinit var txtTotalConta : EditText
    private lateinit var txtPessoas : EditText
    private lateinit var skGorjeta : SeekBar

    private val formatador = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicialização das variáveis criadas acima

        txtTotalConta = this.findViewById<EditText>(R.id.txtTotalConta)
        //O this é a classe MainActivity
        //Quando esse método for executado, ele executará o método onFocusChange(), que está
        //declarado abaixo
        txtTotalConta.setOnFocusChangeListener(this)

        txtPessoas = this.findViewById<EditText>(R.id.txtTotalPessoas)
        txtPessoas.setOnFocusChangeListener(this)

        skGorjeta = this.findViewById<SeekBar>(R.id.skGorjeta)
        skGorjeta.setOnSeekBarChangeListener(this)
    }

    //Esse método é do evento EditText
    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        this.atualizaDadosConta()
    }

    //Os três métodos abaixo pertencem à interface SeekBar
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        var lblPercentualGorjeta = this.findViewById<TextView>(R.id.lblPercentualGorjeta)
        lblPercentualGorjeta.setText(skGorjeta.progress.toString() + "%")
        this.atualizaDadosConta()
    }

    private fun atualizaDadosConta() {
        if(txtTotalConta.text.toString().isNotEmpty()
            && txtPessoas.text.toString().isNotEmpty()) {
            //Criação de variáveis para obter os valores correspondentes convertidos
            var valorConta = txtTotalConta.text.toString().toDouble()
            var qtdPessoas = txtPessoas.text.toString().toInt()

            //Criação de variável para localizar o label onde retornará o valor
            var lblValorRealGorjeta = this.findViewById<TextView>(R.id.lblValorRealGorjeta)

            //Criação de variável para a receber a regra de negócio do método
            var valorRealGorjeta = valorConta * skGorjeta.progress/100
            lblValorRealGorjeta.setText(formatador.format(valorRealGorjeta))

            var lblRealTotalConta = this.findViewById<TextView>(R.id.lblRealTotalConta)
            lblRealTotalConta.setText(formatador.format(valorConta + valorRealGorjeta))

            var lblTotalRealPorPessoa = this.findViewById<TextView>(R.id.lblTotalRealPorPessoa)
            lblTotalRealPorPessoa.setText(formatador.format((valorConta + valorRealGorjeta) / qtdPessoas))
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}