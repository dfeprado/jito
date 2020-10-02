package com.example.jito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewJito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_jito)

        findViewById<Button>(R.id.btnSalvarNovoJito).setOnClickListener(fun (view: View): Unit {
            val titulo: EditText = findViewById(R.id.tituloNovoJito);
            val descricao: EditText = findViewById(R.id.descricaoNovoJito);
            if (titulo.text.trim().isBlank()) {
                Toast.makeText(this, "Você precisa dar um título ao JITO", Toast.LENGTH_SHORT).show();
                return;
            }

            intent.putExtra("jito_titulo", titulo.text.trim());
            intent.putExtra("jito_descricao", descricao.text.trim());
            setResult(RESULT_OK, intent);
            this.finish();
        });
    }
}