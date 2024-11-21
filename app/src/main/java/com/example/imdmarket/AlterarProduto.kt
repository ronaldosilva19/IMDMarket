package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        binding.alterar.setOnClickListener {
            val alteraCodigo = binding.alteraCodigo.text.toString()

            if(alteraCodigo.isEmpty()){
                Toast.makeText(this, "O campo de 'Codigo de produto' eh obrigatorio.", Toast.LENGTH_LONG).show()
            }else{
                // Faz algo e volta para a tela de Menu.
                Toast.makeText(this, "Produto com codigo $alteraCodigo alterado com sucesso.", Toast.LENGTH_LONG).show()
                val menu = Intent(this, Menu::class.java)
                startActivity(menu)
            }
        }

        binding.limpar.setOnClickListener {
            binding.alteraCodigo.setText("")
            binding.nomeProduto.setText("")
            binding.descricaoProduto.setText("")
            binding.estoqueProduto.setText("")
        }
    }
}