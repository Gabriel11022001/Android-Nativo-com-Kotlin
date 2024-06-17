package com.example.app_elementos_layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnIrSegundaTela: Button
    private lateinit var btnIrTerceiraTela: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btnIrSegundaTela = findViewById(R.id.btn_ir_segunda_tela)
        this.btnIrTerceiraTela = findViewById(R.id.btn_ir_terceira_tela)

        this.btnIrSegundaTela.setOnClickListener() {
            var intent = Intent(applicationContext, SegundaActivity::class.java)
            startActivity(intent)
        }

        this.btnIrTerceiraTela.setOnClickListener() {
            val intent = Intent(applicationContext, TerceiraActivity::class.java)
            startActivity(intent)
        }

    }

}