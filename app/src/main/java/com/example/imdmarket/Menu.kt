package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.MenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding: MenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ao clicar no botão de cadastrar, vai para a tela de cadastro de produto.
        binding.cadastrarProduto.setOnClickListener {
            val cadastrar = Intent(this, CadastrarProduto::class.java)
            startActivity(cadastrar)
        }

        // Ao clicar no botão de listar produtos, vai para a tela de listagem dos produtos.
        binding.listarProdutos.setOnClickListener {
            val listarProdutos = Intent(this, ListaDeProdutos::class.java)
            startActivity(listarProdutos)

        }

        // Ao clicar no botão de alterar, vai para a tela de alteração do produto.
        binding.alterarProduto.setOnClickListener {
            val alterarProduto = Intent(this, AlterarProduto::class.java)
            startActivity(alterarProduto)

        }

        // Ao clicar no botão de deletar, vai para a tela que deleta um produto.
        binding.deletarProduto.setOnClickListener {
            val deletarProduto = Intent(this, DeletarProduto::class.java)
            startActivity(deletarProduto)

        }
    }
}