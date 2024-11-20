package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.ListaDeProdutosBinding

class ListaDeProdutos : AppCompatActivity() {

    private lateinit var binding: ListaDeProdutosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListaDeProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.voltar.setOnClickListener {
            // Faz algo e volta para a tela de Menu.
            val menu = Intent(this, Menu::class.java)
            startActivity(menu)
        }

    }
}