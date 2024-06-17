class ClienteRepositorio: IRepositorio<Cliente> {

    override fun cadastrar(entidade: Cliente): Boolean {
        println(entidade.id)
        println(entidade.nome)

        return true
    }

    override fun listarTodos(): ArrayList<Cliente> {

        return ArrayList()
    }

}