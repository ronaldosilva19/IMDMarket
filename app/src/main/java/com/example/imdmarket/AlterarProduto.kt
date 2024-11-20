package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.ActivityMainBinding
import com.example.imdmarket.databinding.AlterarProdutoBinding

class AlterarProduto : AppCompatActivity() {

    private lateinit var binding: AlterarProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AlterarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.limpar.setOnClickListener {
            val navegarTelaPrincipal = Intent(this, MainActivity::class.java)
            startActivity(navegarTelaPrincipal)
        }
    }
}