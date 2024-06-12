fun main() {
    /**
     * Nullsafety -> O Kotlyn é uma linguagem
     * que ajuda muito a evitar o NullPpointerException
     */
    var nome: String? = null
    /**
     * no exemplo abaixo, não vai estorar o NullPpinterException,
     * por conta do operador ?, caso a variável esteja apontando
     * para null, será retornado null e não será lançada
     * uma exceção do tipo NullPointerException
     */
    println(nome?.lowercase())
    nome = "Gabriel Rodrigues dos Santos"
    /**
     * no exemplo abaixo, eu garanto que
     * o valor atribuido a variável não é nullo
     */
    println(nome!!.lowercase())
}