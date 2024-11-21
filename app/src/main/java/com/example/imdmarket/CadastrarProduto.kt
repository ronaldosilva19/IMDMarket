package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

            var codigoProduto = binding.codigoProduto.text.toString()
            var nomeProduto = binding.nomeProduto.text.toString()
            var descricaoProduto = binding.descricaoProduto.text.toString()
            var estoque = binding.estoqueProduto.text.toString()

            if(codigoProduto.isNotEmpty() && nomeProduto.isNotEmpty() && descricaoProduto.isNotEmpty() && estoque.isNotEmpty()){
                // Faz algo e volta para a tela de Menu.
                Toast.makeText(this, "Produto cadastrado com sucesso.", Toast.LENGTH_LONG).show()
                val salvar = Intent(this, Menu::class.java)
                startActivity(salvar)
            }else {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }

        binding.limpar.setOnClickListener {
            binding.codigoProduto.setText("")
            binding.nomeProduto.setText("")
            binding.descricaoProduto.setText("")
            binding.estoqueProduto.setText("")
        }
    }
}