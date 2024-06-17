package com.example.primeiro_app

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var contextoApp: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d("teste", "O método onCreate é o primeiro a ser executado no cliclo de vida da Activity!")
        this.contextoApp = applicationContext
        this.apresentarMensagem()
    }

    fun apresentarMensagem() {
        Toast.makeText(this.contextoApp, "Seja bem vindo!", Toast.LENGTH_LONG).show()
    }

}