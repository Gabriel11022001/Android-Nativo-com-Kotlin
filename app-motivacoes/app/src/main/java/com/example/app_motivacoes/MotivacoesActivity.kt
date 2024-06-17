package com.example.app_motivacoes

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_motivacoes.models.FraseMotivacional
import com.example.app_motivacoes.utils.GeradorMensagemMotivacional

class MotivacoesActivity : AppCompatActivity(), OnClickListener {

    private lateinit var txtBemVindo: TextView
    private lateinit var txtMensagem: TextView
    private lateinit var btnGerarNovamente: Button
    private lateinit var btnTodos: ImageView
    private lateinit var btnFeliz: ImageView
    private lateinit var btnPositivo: ImageView
    private var categoriaAtual: String = "todos"
    private lateinit var geradorMensagemMotivacional: GeradorMensagemMotivacional

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivacoes)
        // mapeando elementos de interface
        this.mapearElementosInterface()
        // mapeando eventos
        this.mapearEventos()
        // mostrar mensagem motivacional inicial
        this.geradorMensagemMotivacional = GeradorMensagemMotivacional()
        this.apresentarMensagemMotivacional()
        this.apresentarBemVindo()
    }

    private fun apresentarBemVindo() {
        val nomeUsuario: String = intent.getStringExtra("nome_usuario")!!
        this.txtBemVindo.text = "Seja bem vindo ${ nomeUsuario }"
    }

    private fun mapearElementosInterface() {
        this.btnFeliz = findViewById(R.id.btn_feliz)
        this.btnTodos = findViewById(R.id.btn_todos)
        this.btnPositivo = findViewById(R.id.btn_positivo)
        this.btnGerarNovamente = findViewById(R.id.btn_nova_mensagem)
        this.txtBemVindo = findViewById(R.id.txt_bem_vindo)
        this.txtMensagem = findViewById(R.id.txt_mensagem)
    }

    private fun mapearEventos() {
        this.btnFeliz.setOnClickListener(this)
        this.btnTodos.setOnClickListener(this)
        this.btnPositivo.setOnClickListener(this)
        this.btnGerarNovamente.setOnClickListener(this)
    }

    private fun trocarCategoria(categoriaSelecionada: String) {
        this.categoriaAtual = categoriaSelecionada
        this.apresentarMensagemMotivacional()
    }

    private fun apresentarMensagemMotivacional() {
        val categoria: String = this.categoriaAtual
        val mensagemMotivacional: String = this.geradorMensagemMotivacional.obterFrase(categoria)
        this.txtMensagem.text = mensagemMotivacional
    }

    override fun onClick(p0: View?) {

        if (p0!!.id == R.id.btn_nova_mensagem) {
            // o usuário clicou no botão para gerar uma nova mensagem
            apresentarMensagemMotivacional()
        } else {
            // o usuário alterou a categoria da mensagem
            var categoria: String = ""

            if (p0!!.id == R.id.btn_todos) {
                categoria = "todos"
            } else if (p0!!.id == R.id.btn_feliz) {
                categoria = "feliz"
            } else {
                categoria = "positivo"
            }

            trocarCategoria(categoria)
        }

    }

}