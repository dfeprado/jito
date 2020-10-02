package com.example.jito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val NOVO_JITO: Int = 1;

class ListaJitos : AppCompatActivity() {

    private val listaJitos: MutableList<Jito> = mutableListOf<Jito>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jitos)

        findViewById<FloatingActionButton>(R.id.btnNovoJito).setOnClickListener {
            startActivityForResult(
                Intent(this, NewJito::class.java),
                NOVO_JITO
            );
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            val jito = Jito(1);
            jito.titulo = data?.getStringExtra("jito_titulo") ?: "";
            jito.descricao = data?.getStringExtra("jito_descricao") ?: "";

            listaJitos.add(jito);
        }
    }

    override fun onResume() {
        super.onResume()
        if (listaJitos.isNotEmpty())
            findViewById<TextView>(R.id.textView).setText("Você tem ${listaJitos.size} jitos cadastrados");
    }
}