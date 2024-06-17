package com.example.app_motivacoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnContinar: Button
    private lateinit var edtNome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // mapeando elementos de interface
        this.btnContinar = findViewById(R.id.btn_continuar)
        this.edtNome = findViewById(R.id.edt_nome_usuario)
        // mapeado evento de clique
        this.btnContinar.setOnClickListener {
            redirecionarTelaMotivacoes()
        }
    }

    private fun redirecionarTelaMotivacoes() {
        val nome: String = this.edtNome.text.toString()

        if (nome.isEmpty()) {
            Toast.makeText(applicationContext, "Informe seu nome!", Toast.LENGTH_LONG)
                .show()
        } else {
            val intent: Intent = Intent(applicationContext, MotivacoesActivity::class.java)
            intent.putExtra("nome_usuario", nome)
            startActivity(intent)
        }

    }

}