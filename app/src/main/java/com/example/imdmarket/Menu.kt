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

        binding.cadastrarProduto.setOnClickListener {
            val cadastrar = Intent(this, CadastrarProduto::class.java)
            startActivity(cadastrar)
        }


        binding.listarProdutos.setOnClickListener {
            val listarProdutos = Intent(this, ListaDeProdutos::class.java)
            startActivity(listarProdutos)

        }

        binding.alterarProduto.setOnClickListener {
            val alterarProduto = Intent(this, AlterarProduto::class.java)
            startActivity(alterarProduto)

        }

        binding.deletarProduto.setOnClickListener {
            val deletarProduto = Intent(this, DeletarProduto::class.java)
            startActivity(deletarProduto)

        }
    }
}