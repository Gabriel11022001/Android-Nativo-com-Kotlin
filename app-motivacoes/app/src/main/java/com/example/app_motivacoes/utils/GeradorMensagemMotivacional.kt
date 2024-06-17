package com.example.app_motivacoes.utils

import android.util.Log
import com.example.app_motivacoes.models.FraseMotivacional
import kotlin.random.Random

class GeradorMensagemMotivacional() {

    private val frases: ArrayList<FraseMotivacional> = ArrayList()

    init {
        this.cadastrarFrases()
    }

    private fun cadastrarFrases() {
        this.frases.add(FraseMotivacional("todos", "Frase motivacional 1"))
        this.frases.add(FraseMotivacional("todos", "Frase motivacional 2"))
        this.frases.add(FraseMotivacional("todos", "Frase motivacional 3"))
        this.frases.add(FraseMotivacional("feliz", "Frase motivacional 4"))
        this.frases.add(FraseMotivacional("feliz", "Frase motivacional 5"))
        this.frases.add(FraseMotivacional("feliz", "Frase motivacional 6"))
        this.frases.add(FraseMotivacional("feliz", "Frase motivacional 7"))
        this.frases.add(FraseMotivacional("feliz", "Frase motivacional 8"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 9"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 10"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 11"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 12"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 13"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 14"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 15"))
        this.frases.add(FraseMotivacional("positivo", "Frase motivacional 16"))
    }

    fun obterFrase(categoria: String): String {
        val frasesCategoria: ArrayList<FraseMotivacional> = ArrayList()
        Log.i("categoria", categoria)

        for (frase in this.frases) {

            if (frase.categoria == categoria) {
                frasesCategoria.add(frase)
            }

        }

        if (frasesCategoria.size == 0) {
            Log.i("teste", "Não existem frases com essa categoria!")
            throw Exception("Não existem frases com essa categoria!")
        }

        for (frase in frasesCategoria) {
            Log.d("teste", frase.frase.uppercase())
        }

        val indice: Int = Random.nextInt(0, frasesCategoria.size)
        val frase: FraseMotivacional = frasesCategoria.get(indice)

        return frase.frase
    }

}