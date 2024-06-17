package com.example.app_gastos_viagem

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * para implementar o evento de clique, podemos fazer com que
 * a classe correspondente a activity, implemente a interface correspondente
 * ao evento, essa interface nos obriga a implementar um método
 * que se chama onClick() e é nesse método que tratamos o evento de clique
 */
class MainActivity : AppCompatActivity(), OnClickListener {

    // propriedades que serão mapeadas para os elementos de interface
    private lateinit var btnCalcular: Button
    private lateinit var edtPrecoCombustivel: EditText
    private lateinit var edtKilometragemCarro: EditText
    private lateinit var edtTotalKm: EditText
    private lateinit var txtGasto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // mapeando os elementos de interface
        this.mapearElementosInterface()
        // mapeando os eventos
        this.mapearEventos()
    }

    private fun mapearElementosInterface() {
        /**
         * para mapear os elementos de interface, precisamos do retorno
         * do método findViewById() que recebe como argumento o id do elemento
         * de interface e retorna um objeto da classe correspondente
         * ao elemento
         */
        this.btnCalcular = findViewById(R.id.btn_calcular_gasto)
        this.edtTotalKm = findViewById(R.id.edt_total_km)
        this.edtPrecoCombustivel = findViewById(R.id.edt_preco_litro)
        this.edtKilometragemCarro = findViewById(R.id.edt_autonomia)
        this.txtGasto = findViewById(R.id.txt_gasto_total)
    }

    private fun mapearEventos() {
        // o elemento(objeto) deve invocar o método setOnClickListener() passando this como argumento
        this.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        // método onde o evento de clique será tratado

        if (p0!!.id == this.btnCalcular.id) {
            Log.i("teste", "O usuário clicou no botão para calcular os gastos totais!")
            this.calcularGastos()
        } else {
            Log.i("teste", "O usuário clicou em outro elemento que implementa o listener de clique!");
        }

    }

    private fun validarCampos(): Boolean {
        var ok = true

        if (this.edtTotalKm.text != null) {

            if (this.edtTotalKm.text.toString().trim().isEmpty()) {
                ok = false
                this.edtTotalKm.error = "Informe o total de KM"
            } else if (this.edtTotalKm.text.toString().toDouble() <= 0) {
                ok = false
                this.edtTotalKm.error = "Total de KM inválido"
            }

        } else {
            ok = false
            this.edtTotalKm.error = "Informe o toal de KM"
        }

        if (this.edtPrecoCombustivel.text != null) {

            if (this.edtPrecoCombustivel.text.toString().trim().isEmpty()) {
                ok = false
                this.edtPrecoCombustivel.error = "Informe o preço do combustível"
            } else if (this.edtPrecoCombustivel.text.toString().toDouble() <= 0) {
                ok = false
                this.edtPrecoCombustivel.error = "Preço do combustível inválido"
            }

        } else {
            ok = false
            this.edtPrecoCombustivel.error = "Informe o preço do combustível"
        }

        return ok
    }

    private fun calcularGastos() {

        try {

            if (this.validarCampos()) {
                val quantidadeLitrosNecessarios: Double = this.edtTotalKm.text.toString().toDouble() / this.edtKilometragemCarro.text.toString().toDouble()
                val valorTotal: Double = quantidadeLitrosNecessarios * this.edtPrecoCombustivel.text.toString().toDouble()
                Log.i("teste", valorTotal.toString())
                this.txtGasto.text = "R$${ valorTotal }"
            } else {
                Toast.makeText(applicationContext, "Ocorreram erros de validação de dados!", Toast.LENGTH_LONG)
                    .show()
            }

        } catch (e: Exception) {
            Log.e("erro", "Ocorreu o seguinte erro: ${ e.message }")
        }

    }

}