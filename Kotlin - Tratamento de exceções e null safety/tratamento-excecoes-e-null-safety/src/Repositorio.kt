abstract class Repositorio<T> {

    open abstract fun cadastrar(entidade: T): Boolean

    open abstract fun listarTodos(): ArrayList<T>

}