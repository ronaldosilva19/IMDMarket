package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.CadastrarProdutoBinding

class CadastrarProduto : AppCompatActivity() {
    private lateinit var binding: CadastrarProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CadastrarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.salvar.setOnClickListener {
            // Faz algo e volta para a tela de Menu.
            val salvar = Intent(this, Menu::class.java)
            startActivity(salvar)
        }
    }
}