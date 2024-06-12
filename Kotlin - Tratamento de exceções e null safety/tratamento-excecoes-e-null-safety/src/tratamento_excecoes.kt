class NomeInvalidoException: Exception() { }

fun main() {

    try {
        var nome: String? = null
        // println(nome!!.uppercase())
        var array = arrayOf(12, 11, 11)

        for (elemento in array) {
            println("Elemento: ${ elemento }")
        }

        // array[3] = 22
        var primeiroValor: Int = 22
        var segundoValor: Int = 0
        // println(primeiroValor / segundoValor)

        var nomePessoa: String = ""
        println("Informe seu nome:")
        nomePessoa = readLine().toString()

        if (nomePessoa.trim().isEmpty()) {
            throw NomeInvalidoException()
        }

        println("Nome: ${ nomePessoa }")
    } catch (e: NullPointerException) {
        println("Estorou um NullPointerException: " + e.message)
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Estorou um ArrayIndexOutOfBoundsException: ${ e.message }")
    } catch (e: NomeInvalidoException) {
        println("O nome informado é inválido!")
    } catch (e: Exception) {
        println("Estorou qualquer outra exceção que não foi tratada logo acima!")
        println(e.message)
    } finally {
        // o finally sempre será executado
        println("Executando o finally!")
    }

}