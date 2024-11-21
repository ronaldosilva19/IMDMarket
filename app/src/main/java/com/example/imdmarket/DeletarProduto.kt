package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.DeletarProdutoBinding

class DeletarProduto : AppCompatActivity() {

    private lateinit var binding: DeletarProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DeletarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deletar.setOnClickListener {
            var deletaProduto = binding.codigoProduto.text.toString()

            if(deletaProduto.isNotEmpty()){
                // Faz algo e volta para a tela de Menu.
                Toast.makeText(this, "Produto deletado com sucesso.", Toast.LENGTH_LONG).show()
                val menu = Intent(this, Menu::class.java)
                startActivity(menu)
            }else{
                Toast.makeText(this, "O campo de 'Codigo de produto' esta vazio.", Toast.LENGTH_LONG).show()

            }
        }

        binding.limpar.setOnClickListener {
            binding.codigoProduto.setText("")
        }
    }
}