package com.example.jito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var addJitoButton: FloatingActionButton;
    private val jitosSelecionados: MutableList<Jito> = mutableListOf<Jito>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    override fun onResume() {
        super.onResume()
        if (jitosSelecionados.isEmpty())
            openNewJitoActivity();
    }

    private fun openNewJitoActivity() {
        startActivity(
            Intent(this, ListaJitos::class.java)
        );
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val jito = Jito(1);
                jito.titulo = data?.getStringExtra("atividade") ?: "";

                jitosSelecionados.add(jito);

                Toast.makeText(this, "Você criou uma atividade ${jito}", Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(this, "Recebemos uma resposta estranha, Bill!", Toast.LENGTH_SHORT).show();
    }
}