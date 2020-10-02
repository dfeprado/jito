package com.example.jito

class Jito(val id: Int) {
    var titulo: String = "";
    var descricao: String = "";
    private var concluido: String = ""
        get() = concluido;

    val registro: String = "hoje";
    var selecionado: String = "";

    fun setConcluido() {
        if (concluido.isNotBlank())
            return;

        concluido = "Agorinha mesmo";
    }
}