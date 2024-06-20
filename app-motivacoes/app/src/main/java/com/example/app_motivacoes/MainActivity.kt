package com.example.app_motivacoes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

    override fun onStart() {
        super.onStart()
        this.validarNomeUsuarioJaFoiInformado()
    }

    private fun validarNomeUsuarioJaFoiInformado() {
        val preferenciasUsuario: SharedPreferences = application.getSharedPreferences("preferencias_app_motivacoes", Context.MODE_PRIVATE)

        if (preferenciasUsuario.contains("nome_usuario_logado") && !preferenciasUsuario.getString("nome_usuario_logado", "")!!.isEmpty()) {
            // o nome do usuário já foi informado
            val activityMotivacoes = Intent(applicationContext, MotivacoesActivity::class.java)
            startActivity(activityMotivacoes)
            finish()
        }

    }

    private fun salvarNomeUsuarioSharedPreferences(nomeInformado: String) {
        // obter uma instância de SharedPreferences
        val preferenciasCompartilhadas: SharedPreferences = applicationContext
            .getSharedPreferences("preferencias_app_motivacoes", Context.MODE_PRIVATE)
        // editar as preferências compartilhadas
        val editor = preferenciasCompartilhadas.edit()
        // adicionar um valor nas preferências compartilhadas
        editor.putString("nome_usuario_logado", nomeInformado)
        // aplicar as alterações
        editor.apply()
    }

    private fun redirecionarTelaMotivacoes() {

        try {
            val nome: String = this.edtNome.text.toString()

            if (nome.isEmpty()) {
                Toast.makeText(applicationContext, "Informe seu nome!", Toast.LENGTH_LONG)
                    .show()
            } else {
                this.salvarNomeUsuarioSharedPreferences(nome)
                val intent: Intent = Intent(applicationContext, MotivacoesActivity::class.java)
                // serve para passar dados para a activity de destino
                intent.putExtra("nome_usuario", nome)
                // método que serve para abrir uma nova activity
                startActivity(intent)
                // esse método remove a activity da pilha de execução
                finish()
            }

        } catch (e: Exception) {
            Log.e("teste_erro", e.message.toString())
            Toast.makeText(applicationContext, "Ocorreu um erro ao tentar-se informar o nome do usuário!", Toast.LENGTH_LONG)
                .show()
        }

    }

}