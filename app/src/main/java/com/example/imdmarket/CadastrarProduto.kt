package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.CadastrarProdutoBinding

class CadastrarProduto : AppCompatActivity() {
    private lateinit var binding: CadastrarProdutoBinding
    private lateinit var bancoProduto: BancoProduto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CadastrarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bancoProduto = BancoProduto(this)

        binding.salvar.setOnClickListener  {

            var codigoProduto = binding.codigoProduto.text.toString()
            var nomeProduto = binding.nomeProduto.text.toString()
            var descricaoProduto = binding.descricaoProduto.text.toString()
            var estoque = binding.estoqueProduto.text.toString()


            if(codigoProduto.isNotEmpty() && nomeProduto.isNotEmpty() && descricaoProduto.isNotEmpty() && estoque.isNotEmpty()){
                // Faz algo e volta para a tela de Menu.
                bancoProduto.salvarProduto(codigoProduto.toLong(), nomeProduto, descricaoProduto, estoque.toInt())
                Toast.makeText(this, "Produto cadastrado com sucesso.", Toast.LENGTH_LONG).show()
                val menu = Intent(this, Menu::class.java)
                startActivity(menu)
            }else {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }

        // Limpa todos os campos digitáveis.
        binding.limpar.setOnClickListener {
            binding.codigoProduto.setText("")
            binding.nomeProduto.setText("")
            binding.descricaoProduto.setText("")
            binding.estoqueProduto.setText("")
        }

    }

}