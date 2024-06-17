class ProdutoRepositorio: Repositorio<Produto>() {

    override fun cadastrar(entidade: Produto): Boolean {

        return true
    }

    override fun listarTodos(): ArrayList<Produto> {

        return arrayListOf(
            Produto(1, "Coca-Cola", 12.98)
        )
    }

}