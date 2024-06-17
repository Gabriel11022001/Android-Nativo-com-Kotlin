interface IRepositorio<T> {

    fun cadastrar(entidade: T): Boolean

    fun listarTodos(): ArrayList<T>

}