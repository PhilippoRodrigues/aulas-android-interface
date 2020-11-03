package br.edu.infnet.androidloginsenha.model

import java.io.Serializable

class Usuario (
    var nome: String,
    var idade: Int,
    var telefone: String,
    var matricula: Int,
    var peso: Double = 0.0,
    var altura: Double = 0.0,
): Serializable {
    override fun toString(): String {
        return "Nome:\t$nome\n" +
                "Idade: \t$idade\n" +
                "Telefone: \t$telefone\n" +
                "Matrícula: \t$matricula\n" +
                "Peso: \t$peso\n" +
                "Altura: \t$altura"
    }
}