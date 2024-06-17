fun main() {
    val produtoRepositorio: ProdutoRepositorio = ProdutoRepositorio()
    val produtos: ArrayList<Produto> = produtoRepositorio.listarTodos()

    for (prod in produtos) {
        println(prod.id)
        println(prod.descricao)
    }

    val clienteRepositorio: ClienteRepositorio = ClienteRepositorio()
    val cliente: Cliente = Cliente(1, "Gabriel Rodrigues dos Santos")
    clienteRepositorio.cadastrar(cliente)
}