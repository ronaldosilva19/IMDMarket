package com.example.imdmarket

class Produto(
    private var codigoProduto: String,
    private var nomeProduto: String,
    private var descricaoProduto: String,
    private var estoque: Int

){
    override fun toString(): String {
        return "Codigo: $codigoProduto \n" +
                "Nome do Produto: $nomeProduto\n" +
                "Descricao do Produto: $descricaoProduto\n" +
                "Estoque: $estoque\n"
    }
}